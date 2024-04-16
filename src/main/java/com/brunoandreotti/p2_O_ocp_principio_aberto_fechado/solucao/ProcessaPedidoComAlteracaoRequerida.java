package com.brunoandreotti.p2_O_ocp_principio_aberto_fechado.solucao;


import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;
import com.brunoandreotti.p2_O_ocp_principio_aberto_fechado.violacao.ProcessaPedidoSemValidação;

/**
 * OCP SOLUÇÃO
 */
public class ProcessaPedidoComAlteracaoRequerida extends ProcessaPedidoSemValidação {

    /**
        Para solucionarmos a demanda respeitando o OCP o que precisamos fazer é uma cria nova classe
        extendendo a classe original e adicionar a validação nesta classe herdou a classe original.
        Uma vez que o OCP diz que estamos fechados para modificação mas abertos para extensão,
        podemos criar o novo comportamento extendendo o comportamento original
     */
    
    public void processar(Pedido pedido) {
        // Antes do processamento
        if (!pedido.possuiItens()) {
            throw new RuntimeException("Não é possível continuar! Pedido sem itens.");
        }
        
        super.processar(pedido);

        // Depois do processamento
        if (!pedido.isValid()) {
            throw new RuntimeException("Não é possível continuar! Pedido sem Id");
        }

    }

}
