/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.autorizacaopagamento.business.excecoes;

/**
 *
 * @author Clayton
 */
public final class SuperioresIndisponiveisException extends RuntimeException {

    public SuperioresIndisponiveisException() {
        super("Todos os superiores estão indisponíveis!");
    }

}
