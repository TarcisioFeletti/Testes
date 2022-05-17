package com.ufes.autorizacaopagamento.business;

public class GerenteImediato extends SuperiorHierarquico {

    public GerenteImediato(boolean disponivel) {
        super(disponivel);
    }

    @Override
    public final boolean aceitar(double valor) {
        return (valor <= 500.00 && disponivel);
    }

    @Override
    public String toString() {
        return "Gerente imediato";
    }

}
