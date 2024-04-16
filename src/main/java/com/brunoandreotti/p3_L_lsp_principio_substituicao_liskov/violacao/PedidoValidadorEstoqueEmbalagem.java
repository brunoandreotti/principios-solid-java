package com.brunoandreotti.p3_L_lsp_principio_substituicao_liskov.violacao;

/**
 * LSP VIOLAÇÃO - QUEBRA O CONTRATO DA HERANÇA
 * Uma classe derivada deve ser substituível por sua classe base sem prejudicar o funcionamento do sistema
 */
public class PedidoValidadorEstoqueEmbalagem extends PedidoValidadorEstoque {

    /**
     * Neste caso temos a violação do LSP pois a classe filha está com um comportamento diferente da classe mãe.
     * E isso poderia quebrar o sistema.
     * A função da classe mãe é apenas retornar true ou false dependendo da validação
     * Porém na classe filha foi adicionado um comportamento de lançar um exceção ao invés de retonar um boolean
     */

    @Override
    public boolean isValid(Pedido pedido) {
        for (Item item : pedido.getItens()) {
            if (!item.emEstoque()) {
                return false;
            }

            if (!item.foiEmbalado()) {
                throw new RuntimeException("Item não foi embalado! Retorne ao CD(Centro de Distribuição).");
            }
        }

        return true;
    }

}
