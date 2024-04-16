package com.brunoandreotti.p5_D_dip_principio_inversao_dependencia.violacao;

import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;

/**
 * DIP VIOLAÇÃO
 */
public class OracleRepository {

    public boolean salvar(Pedido pedido) {
        ConexaoOracle dbConnection = new ConexaoOracle("database.url");

        try {
            dbConnection.salvar(pedido);
        } catch (Exception e) {
            // log
            return false;
        }

        return true;
    }

}
