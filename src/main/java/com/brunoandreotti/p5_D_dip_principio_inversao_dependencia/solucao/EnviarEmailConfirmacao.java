package com.brunoandreotti.p5_D_dip_principio_inversao_dependencia.solucao;


import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;
import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.SmtpGmail;

/**
 * DIP SOLUÇÃO
 */
public class EnviarEmailConfirmacao implements IEnvioEmailRepository {

    public void enviarEmailConfirmacao(Pedido pedido) {
        SmtpGmail smtp = new SmtpGmail("usuarioSmtp", "senhaSmtp");
        String nome = pedido.getNomeCliente();
        String email = pedido.getEmailCliente();

        String html = "Caro cliente ".concat(nome).concat(", seu Pedido ")
                .concat(pedido.getId().toString()).concat(" foi confirmado!😎");

        smtp.enviar(html, email);
    }

}
