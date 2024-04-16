package com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao;

/**
 * SRP VIOLAÇÃO
 * Uma classe deve ter um, e somente um, motivo para mudar.
 * Esse princípio declara que uma classe deve ser especializada em um único assunto
 * e possuir apenas uma responsabilidade dentro do software
 * , ou seja, a classe deve ter uma única tarefa ou ação para executar.
 */
public class ProcessaPedido {

    /**
     Neste caso, além de possuir a responsabilidade de processar o pedido, a classe também possui
     a responsabilidade de salvar o pedido e de enviar email.
     Dessa forma desrespeitando o SRP
     */

    public Pedido processar(Pedido pedido) {
        // Regra de negócio processar pedido

        boolean persistidoBanco = salvar(pedido);

        if (pedido.isValid() && persistidoBanco) {
            enviarEmailConfirmacao(pedido);
        }

        return pedido;
    }

    private boolean salvar(Pedido pedido) {
        ConexaoPostgres dbConnection = new ConexaoPostgres("database.url");

        try {
            dbConnection.salvar(pedido);
        } catch (Exception e) {
            // log
            return false;
        }

        return true;
    }

    private void enviarEmailConfirmacao(Pedido pedido) {
        SmtpGmail smtp = new SmtpGmail("usuarioSmtp", "senhaSmtp");
        String nome = pedido.getNomeCliente();
        String email = pedido.getEmailCliente();

        String html = "Caro cliente ".concat(nome).concat(", seu Pedido ")
                .concat(pedido.getId().toString()).concat(" foi confirmado!😎");

        smtp.enviar(html, email);
    }

}
