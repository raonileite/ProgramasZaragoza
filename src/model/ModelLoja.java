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
public class ModelLoja {
    private int lojId;
    private String lojSigla;
    private String lojCidade;

    /**
     * @return the lojId
     */
    public int getLojId() {
        return lojId;
    }

    /**
     * @param lojId the lojId to set
     */
    public void setLojId(int lojId) {
        this.lojId = lojId;
    }

    /**
     * @return the lojSigla
     */
    public String getLojSigla() {
        return lojSigla;
    }

    /**
     * @param lojSigla the lojSigla to set
     */
    public void setLojSigla(String lojSigla) {
        this.lojSigla = lojSigla;
    }

    /**
     * @return the lojCidade
     */
    public String getLojCidade() {
        return lojCidade;
    }

    /**
     * @param lojCidade the lojCidade to set
     */
    public void setLojCidade(String lojCidade) {
        this.lojCidade = lojCidade;
    }
    
}
