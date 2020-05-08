/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ti.raoni
 */
public class ModelFormaPagamento {
    private int pagId;
    private String pagForma;

    /**
     * @return the pagId
     */
    public int getPagId() {
        return pagId;
    }

    /**
     * @param pagId the pagId to set
     */
    public void setPagId(int pagId) {
        this.pagId = pagId;
    }

    /**
     * @return the pagForma
     */
    public String getPagForma() {
        return pagForma;
    }

    /**
     * @param pagForma the pagForma to set
     */
    public void setPagForma(String pagForma) {
        this.pagForma = pagForma;
    }
}
