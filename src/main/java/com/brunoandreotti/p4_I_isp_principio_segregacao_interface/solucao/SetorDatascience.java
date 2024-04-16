package com.brunoandreotti.p4_I_isp_principio_segregacao_interface.solucao;

/**
 * ISP SOLUÇÃO
 */
public class SetorDatascience implements IGerarRelatorioVendasExcel {

    /**
     * Para respeitarmos o ISP é necessário criar duas interfaces diferentes para cada método
     * e dessa maneira conseguimos escolher quais interfaces implementar dependendo da necessidade da classe.
     */

    @Override
    public void gerarExcel() {
        System.out.println("Show! Super útil para mim.");
    }
    
}
