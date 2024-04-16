package com.brunoandreotti.p4_I_isp_principio_segregacao_interface.violacao;

/**
 * ISP VIOLAÇÃO
 * Nenhuma implementação de uma interface deve ser obrigada a implementar
 * um método que não será utilizada por ela
 */
public class SetorDatascience implements IGerarRelatorioVendas {

    /**
     * Neste caso estamos violando o ISP pois estamos implementando um interface com 2 métodos
     * porém a implementação só necessita de utilizar um dos métodos
     */

    @Override
    public void gerarExcel() {
        System.out.println("Show! Super útil para mim.");
    }
    
    @Override
    public void gerarPDF() {
        System.out.println("Não, isso é muito inútil, nunca vou usar!");
    }
    
}
