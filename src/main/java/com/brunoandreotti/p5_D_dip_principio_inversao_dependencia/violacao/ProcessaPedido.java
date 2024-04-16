package com.brunoandreotti.p5_D_dip_principio_inversao_dependencia.violacao;

import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;

/**
 * DIP VIOLAÇÃO
 * Esse principio diz que uma classe não deve depender diretamente de implementações/classes concretas
 * e sim de interfaces
 */
public class ProcessaPedido {

    /**
     * Neste caso estamos violando o DIP pois a classe ProcessaPedido está dependendo diretamente
     * de outras implementações/classe concretas ao invés de interfaces.
     */

    public void processar(Pedido pedido) {
        PostgresRepository pgRepo = new PostgresRepository();
        OracleRepository oracleRepo = new OracleRepository();
        EnviarEmailConfirmacao enviarEmail = new EnviarEmailConfirmacao();
        boolean isOracle = true;

        // Regra de negócio processar pedido
        System.out.println("Regra de negócio ao processar pedido...");
        pedido.setNomeCliente("bruno");
        pedido.setEmailCliente("bruno@gmail.com");
        pedido.setId(47);

        if (isOracle) {
            oracleRepo.salvar(pedido);
        } else {
            pgRepo.salvar(pedido);
        }

        enviarEmail.enviarEmailConfirmacao(pedido);

    }

}
