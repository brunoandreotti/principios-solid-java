package com.brunoandreotti.p5_D_dip_principio_inversao_dependencia.solucao;

import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;

/**
 * DIP SOLUÇÃO
 */
public class ProcessaPedido {

    /**
     * Para respeitarmos a DIP basta criar interfaces para que nossas classes implemente-as
     * e, ao invés de dependermos das implementações das classes, nos dependeremos das interfaces.
     * Dessa maneira nãp geramos acoplamento em nosso código
     */

    private IBancoDadosRepository dbRepo;

    private IEnvioEmailRepository mailRepo;

    public ProcessaPedido(IBancoDadosRepository dbRepo, IEnvioEmailRepository mailRepo) {
        this.dbRepo = dbRepo;
        this.mailRepo = mailRepo;
    }

    public void processar(Pedido pedido) {
        // Regra de negócio processar pedido
        System.out.println("Regra de negócio ao processar pedido...");
        pedido.setNomeCliente("bruno");
        pedido.setEmailCliente("bruno@gmail.com");
        pedido.setId(47);

        dbRepo.salvar(pedido);

        mailRepo.enviarEmailConfirmacao(pedido);
    }

}
