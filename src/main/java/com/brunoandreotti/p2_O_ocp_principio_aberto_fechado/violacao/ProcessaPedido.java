package com.brunoandreotti.p2_O_ocp_principio_aberto_fechado.violacao;

import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.solucao.EnviarEmail;
import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.solucao.PostgresRepository;
import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;

/**
 * OCP VIOLAÇÃO - REQUERIDO MUDANÇAS NO PROCESSO E MUDAMOS DIRETAMENTE NA CLASSE
 * Objetos ou entidades devem estar abertos para extensão, mas fechados para modificação,
 * ou seja, quando novos comportamentos e recursos precisam ser adicionados no software,
 * devemos estender e não alterar o código fonte original.
 */
public class ProcessaPedido {

    /**
        Neste caso, suponhamos que por demanda de negócio por solicitado adicionar validações
        antes do processamento do pedido e depois do processamento do pedido na classe ProcessaPedidoSemValidação
        Dessa forma adicionamos as validações diretamente no código "original" da classe e
        assim ferindo o OCP, pois segundo esse principio as classes são fechadas para modificação.
     */
    public void processar(Pedido pedido) {
        // Validação antes do processamento
        if (!pedido.possuiItens()) {
            throw new RuntimeException("Não é possível continuar! Pedido sem itens.");
        }
        
        PostgresRepository pgRepo = new PostgresRepository();
        EnviarEmail enviarEmail = new EnviarEmail();
        
        // Regra de negócio processar pedido
        System.out.println("Regra de negócio ao processar pedido...");
        pedido.setNomeCliente("sandrolaxx");
        pedido.setEmailCliente("sandrolax@gmail.com");
        pedido.setId(47);

        pgRepo.salvar(pedido);

        enviarEmail.enviarEmailConfirmacao(pedido);

        // Validação depois do processamento
        if (!pedido.isValid()) {
            throw new RuntimeException("Não é possível continuar! Pedido sem Id");
        }
    }

}
