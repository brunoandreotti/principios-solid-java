package com.brunoandreotti.p2_O_ocp_principio_aberto_fechado.violacao;

import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.solucao.EnviarEmail;
import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.solucao.PostgresRepository;
import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;


public class ProcessaPedidoSemValidação {


    public void processar(Pedido pedido) {

        
        PostgresRepository pgRepo = new PostgresRepository();
        EnviarEmail enviarEmail = new EnviarEmail();
        
        // Regra de negócio processar pedido
        System.out.println("Regra de negócio ao processar pedido...");
        pedido.setNomeCliente("sandrolaxx");
        pedido.setEmailCliente("sandrolax@gmail.com");
        pedido.setId(47);

        pgRepo.salvar(pedido);

        enviarEmail.enviarEmailConfirmacao(pedido);


    }

}
