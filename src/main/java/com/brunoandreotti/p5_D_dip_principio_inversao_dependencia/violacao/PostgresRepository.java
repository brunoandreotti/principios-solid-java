package com.brunoandreotti.p5_D_dip_principio_inversao_dependencia.violacao;

import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.ConexaoPostgres;
import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;

public class PostgresRepository {

    public boolean salvar(Pedido pedido) {
        ConexaoPostgres dbConnection = new ConexaoPostgres("database.url");

        try {
            dbConnection.salvar(pedido);
        } catch (Exception e) {
            // log
            return false;
        }

        return true;
    }

}
