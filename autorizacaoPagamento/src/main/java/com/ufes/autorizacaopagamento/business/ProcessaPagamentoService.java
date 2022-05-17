package com.ufes.autorizacaopagamento.business;

import com.ufes.autorizacaopagamento.business.excecoes.SuperioresIndisponiveisException;
import com.ufes.autorizacaopagamento.business.excecoes.TratadoresVazioException;
import java.util.ArrayList;

public final class ProcessaPagamentoService {

    private final ArrayList<SuperiorHierarquico> superioresHierarquicos = new ArrayList<>();

    public void addTratador(SuperiorHierarquico tratador) {
        if (tratador == null) {
            throw new IllegalArgumentException("Falha: Instancie um tratador de pagamentos válido!");
        }
        superioresHierarquicos.add(tratador);
    }

    public String processaAprovacao(double valorPagamento) {

        if (valorPagamento <= 0) {
            throw new IllegalArgumentException("Falha: Valor de pagamento inválido:\nO valor deve ser > 0");
        }

        if (valorPagamento > 15000.0) {
            throw new IllegalArgumentException("Falha: O pagamento é superior ao autorização e \\nnão pôde ser processado por nenhum superior hierárquico");
        }

        if (superioresHierarquicos.isEmpty()) {
            throw new TratadoresVazioException();
        }

        String quebraLinha = System.getProperty("line.separator");
        StringBuilder resposta = new StringBuilder();
        int indisponiveis = 0;

        for (SuperiorHierarquico superiorImediato : superioresHierarquicos) {
            if (superiorImediato.aceitar(valorPagamento)) {
                resposta.append(quebraLinha).append(superiorImediato.aprovarPagamento(valorPagamento));
                break;
            } else {
                resposta.append(quebraLinha).append(superiorImediato).append(" não pôde aprovar o pagamento solicitado");
            }
            indisponiveis += !superiorImediato.isDisponivel() ? 1 : 0;
        }

        if (indisponiveis == 4) {
            throw new SuperioresIndisponiveisException();
        }
        return resposta.toString();
    }

}
