package com.ufes.autorizacaopagamento.business;

public class GerenteGeral extends SuperiorHierarquico {

    public GerenteGeral(boolean disponivel) {
        super(disponivel);
    }

    @Override
    public final boolean aceitar(double valor) {
        return (valor > 0 && valor <= 1500.00 && disponivel);
    }

    @Override
    public String toString() {
        return "Gerente Geral";
    }

}
