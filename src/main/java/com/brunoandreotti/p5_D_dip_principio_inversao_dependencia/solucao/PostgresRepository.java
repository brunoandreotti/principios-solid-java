package com.brunoandreotti.p5_D_dip_principio_inversao_dependencia.solucao;

import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.ConexaoPostgres;
import com.brunoandreotti.p1_S_srp_principio_responsabilidade_unica.violacao.Pedido;

/**
 * DIP SOLUÇÃO
 */
public class PostgresRepository implements IBancoDadosRepository {

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
