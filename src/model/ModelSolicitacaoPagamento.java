package model;

import java.sql.Date;

/**
*
* @author Raoni
*/
public class ModelSolicitacaoPagamento {

    /**
     * @return the spFornecedor
     */
    public String getSpFornecedor() {
        return spFornecedor;
    }

    /**
     * @param spFornecedor the spFornecedor to set
     */
    public void setSpFornecedor(String spFornecedor) {
        this.spFornecedor = spFornecedor;
    }

    /**
     * @return the spForma
     */
    public String getSpForma() {
        return spForma;
    }

    /**
     * @param spForma the spForma to set
     */
    public void setSpForma(String spForma) {
        this.spForma = spForma;
    }

    private int idSP;//
    private int idLoja;
    private int idFornecedor;//
    private int idForma;//
    private String spHistorico;//
    private String spObservacoes;//
    private double spValor;//
    private Date spData;//
    private int idUsuario;
    private int spNota;//
    private String spFornecedor;
    private String spForma;

    /**
    * Construtor
    */
    public ModelSolicitacaoPagamento(){}

    /**
    * seta o valor de idSP
    * @param pIdSP
    */
    public void setIdSP(int pIdSP){
        this.idSP = pIdSP;
    }
    /**
    * @return pk_idSP
    */
    public int getIdSP(){
        return this.idSP;
    }

    /**
    * seta o valor de idLoja
    * @param pIdLoja
    */
    public void setIdLoja(int pIdLoja){
        this.idLoja = pIdLoja;
    }
    /**
    * @return fk_idLoja
    */
    public int getIdLoja(){
        return this.idLoja;
    }

    /**
    * seta o valor de idFornecedor
    * @param pIdFornecedor
    */
    public void setIdFornecedor(int pIdFornecedor){
        this.idFornecedor = pIdFornecedor;
    }
    /**
    * @return fk_idFornecedor
    */
    public int getIdFornecedor(){
        return this.idFornecedor;
    }

    /**
    * seta o valor de idForma
    * @param pIdForma
    */
    public void setIdForma(int pIdForma){
        this.idForma = pIdForma;
    }
    /**
    * @return fk_idForma
    */
    public int getIdForma(){
        return this.idForma;
    }

    /**
    * seta o valor de spHistorico
    * @param pSpHistorico
    */
    public void setSpHistorico(String pSpHistorico){
        this.spHistorico = pSpHistorico;
    }
    /**
    * @return spHistorico
    */
    public String getSpHistorico(){
        return this.spHistorico;
    }

    /**
    * seta o valor de spObservacoes
    * @param pSpObservacoes
    */
    public void setSpObservacoes(String pSpObservacoes){
        this.spObservacoes = pSpObservacoes;
    }
    /**
    * @return spObservacoes
    */
    public String getSpObservacoes(){
        return this.spObservacoes;
    }

    /**
    * seta o valor de spValor
    * @param pSpValor
    */
    public void setSpValor(double pSpValor){
        this.spValor = pSpValor;
    }
    /**
    * @return spValor
    */
    public double getSpValor(){
        return this.spValor;
    }

    /**
    * seta o valor de spData
    * @param pSpData
    */
    public void setSpData(Date pSpData){
        this.spData = pSpData;
    }
    /**
    * @return spData
    */
    public Date getSpData(){
        return this.spData;
    }

    /**
    * seta o valor de idUsuario
    * @param pIdUsuario
    */
    public void setIdUsuario(int pIdUsuario){
        this.idUsuario = pIdUsuario;
    }
    /**
    * @return fk_idUsuario
    */
    public int getIdUsuario(){
        return this.idUsuario;
    }

    /**
    * seta o valor de spNota
    * @param pSpNota
    */
    public void setSpNota(int pSpNota){
        this.spNota = pSpNota;
    }
    /**
    * @return spNota
    */
    public int getSpNota(){
        return this.spNota;
    }

    @Override
    public String toString(){
        return "ModelSolicitacaoPagamento {" + "::idSP = " + this.idSP + "::idLoja = " + this.idLoja + "::idFornecedor = " + this.idFornecedor + "::idForma = " + this.idForma + "::spHistorico = " + this.spHistorico + "::spObservacoes = " + this.spObservacoes + "::spValor = " + this.spValor + "::spData = " + this.spData + "::idUsuario = " + this.idUsuario + "::spNota = " + this.spNota +  "}";
    }
}