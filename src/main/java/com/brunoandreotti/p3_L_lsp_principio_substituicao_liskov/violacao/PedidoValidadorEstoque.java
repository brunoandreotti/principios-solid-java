package com.brunoandreotti.p3_L_lsp_principio_substituicao_liskov.violacao;

public class PedidoValidadorEstoque {

    public boolean isValid(Pedido pedido) {
        for (Item item : pedido.getItens()) {
            if (!item.emEstoque()) {
                return false;
            }
        }

        return true;
    }

}
