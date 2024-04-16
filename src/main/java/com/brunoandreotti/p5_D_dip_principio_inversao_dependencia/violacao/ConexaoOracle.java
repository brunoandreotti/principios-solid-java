package com.brunoandreotti.p5_D_dip_principio_inversao_dependencia.violacao;


import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;

public class ConexaoOracle {

    public ConexaoOracle(String dbUrl) {
        // Simulando criação de conexão no oracle
    }
    
    public void salvar(Pedido order) {
        System.out.println("Salvando pedido no ORACLE...");
        // Persistindo dados no banco real
    }

}
