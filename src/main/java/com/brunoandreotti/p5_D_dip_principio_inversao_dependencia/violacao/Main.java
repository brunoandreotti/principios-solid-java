package com.brunoandreotti.p5_D_dip_principio_inversao_dependencia.violacao;

import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;

/**
 * DIP VIOLAÇÃO
 */
public class Main {
    
    public static void main(String[] args) {
        
        ProcessaPedido processaPedido = new ProcessaPedido();

        processaPedido.processar(new Pedido());

    }

}
