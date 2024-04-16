package com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.solucao;

import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;

/**
 * SRP SOLUÇÃO
 */
public class ProcessaPedido {

    /**
     Para solucionar o problema foi necessário criar uma classe para cada outra função.
     Uma classe para salvar o pedido e uma classe para enviar o e-mail
     Dessa forma cada classe ficou apenas com uma responsabilidade
     */

    public void processar(Pedido pedido) {
        PostgresRepository pgRepo = new PostgresRepository();
        EnviarEmail enviarEmail = new EnviarEmail();
        
        // Regra de negócio processar pedido
        System.out.println("Regra de negócio ao processar pedido");
        pedido.setNomeCliente("bruno");
        pedido.setEmailCliente("bruno@gmail.com");
        pedido.setId(47);

        pgRepo.salvar(pedido);

        enviarEmail.enviarEmailConfirmacao(pedido);
    }

}
