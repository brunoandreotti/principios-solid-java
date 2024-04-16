package com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.solucao;

import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;
import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.SmtpGmail;

/**
 * SRP SOLUÇÃO
 */
public class EnviarEmail {

    public void enviarEmailConfirmacao(Pedido pedido) {
        SmtpGmail smtp = new SmtpGmail("usuarioSmtp", "senhaSmtp");
        String nome = pedido.getNomeCliente();
        String email = pedido.getEmailCliente();

        String html = "Caro cliente ".concat(nome).concat(", seu Pedido ")
                .concat(pedido.getId().toString()).concat(" foi confirmado!");

        smtp.enviar(html, email);
    }

}
