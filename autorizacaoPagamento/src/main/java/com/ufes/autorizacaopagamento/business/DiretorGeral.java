package com.ufes.autorizacaopagamento.business;

public class DiretorGeral extends SuperiorHierarquico {

    public DiretorGeral(boolean disponivel) {
        super(disponivel);
    }

    @Override
    public final boolean aceitar(double valor) {
        return (valor > 0 && valor <= 15000.00 && disponivel);
    }

    @Override
    public String toString() {
        return "Diretor Geral";
    }

}
