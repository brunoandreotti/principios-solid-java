package com.brunoandreotti.p5_D_dip_principio_inversao_dependencia.solucao;

import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;

/**
 * DIP SOLUÇÃO
 */
public class Main {

    public static void main(String[] args) {

        PostgresRepository pgRepo = new PostgresRepository();
        OracleRepository oracleRepository = new OracleRepository();
        EnviarEmailConfirmacao sendMail = new EnviarEmailConfirmacao();

        Pedido pedido = new Pedido();

        ProcessaPedido orderProcessor = new ProcessaPedido(pgRepo, sendMail);

        orderProcessor.processar(pedido);
    }

}
