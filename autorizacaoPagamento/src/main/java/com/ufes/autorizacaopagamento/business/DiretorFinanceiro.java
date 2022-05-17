package com.ufes.autorizacaopagamento.business;

public class DiretorFinanceiro extends SuperiorHierarquico {

    public DiretorFinanceiro(boolean disponivel) {
        super(disponivel);
    }

    @Override
    public final boolean aceitar(double valor) {
        return (valor > 0 && valor <= 5000.00 && disponivel);
    }

    @Override
    public String toString() {
        return "Diretor financeiro";
    }

}
