package com.brunoandreotti.p5_D_dip_principio_inversao_dependencia.solucao;


import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;

/**
 * DIP SOLUÇÃO
 */
public interface IEnvioEmailRepository {

    void enviarEmailConfirmacao(Pedido order);

}
