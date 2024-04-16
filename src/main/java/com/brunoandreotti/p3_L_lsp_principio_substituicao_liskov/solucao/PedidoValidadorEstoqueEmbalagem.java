package com.brunoandreotti.p3_L_lsp_principio_substituicao_liskov.solucao;

import com.brunoandreotti.p3_L_lsp_principio_substituicao_liskov.violacao.Item;
import com.brunoandreotti.p3_L_lsp_principio_substituicao_liskov.violacao.Pedido;
import com.brunoandreotti.p3_L_lsp_principio_substituicao_liskov.violacao.PedidoValidadorEstoque;

/**
 * LSP SOLUÇÃO
 */
public class PedidoValidadorEstoqueEmbalagem extends PedidoValidadorEstoque {

    /**
     * Para respeitar o LSP basta retornarmos um boolena (false) ao invés de um exceção
     * no comportamento da classe filha, dessa maneira não estaria alterando o contrato de retorno da classe mãe
     */

    @Override
    public boolean isValid(Pedido pedido) {
        for (Item item : pedido.getItens()) {
            if (!item.emEstoque()) {
                return false;
            }

            if (!item.foiEmbalado()) {
                // LOG do erro - Não quebrar o contrato da herança
                return false;
            }
        }

        return true;
    }

}
