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
public final class TratadoresVazioException extends RuntimeException {

 public TratadoresVazioException() {
        super("Falha: Nenhum superior hierarquico foi adicionado!");
    }

}
