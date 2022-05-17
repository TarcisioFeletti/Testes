package com.ufes.autorizacaopagamento.business;

public abstract class SuperiorHierarquico {

    protected boolean disponivel;

    public SuperiorHierarquico(boolean disponivel) {
        this.disponivel = disponivel;
    }

    abstract boolean aceitar(double valor);

    public String aprovarPagamento(double valor) {
        return this.toString() + " autorizando pagamento no valor de R$ " + valor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
}
