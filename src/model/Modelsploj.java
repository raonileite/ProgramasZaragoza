package model;
/**
*
* @author raoni
*/
public class Modelsploj {

    private int idSPLoj;
    private int idLoja;
    private int idSP;

    /**
    * Construtor
    */
    public Modelsploj(){}

    /**
    * seta o valor de idSPLoj
    * @param pIdSPLoj
    */
    public void setIdSPLoj(int pIdSPLoj){
        this.idSPLoj = pIdSPLoj;
    }
    /**
    * @return pk_idSPLoj
    */
    public int getIdSPLoj(){
        return this.idSPLoj;
    }

    /**
    * seta o valor de idLoja
    * @param pIdLoja
    */
    public void setIdLoja(int pIdLoja){
        this.idLoja = pIdLoja;
    }
    /**
    * @return pk_idLoja
    */
    public int getIdLoja(){
        return this.idLoja;
    }

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

    @Override
    public String toString(){
        return "Modelsploj {" + "::idSPLoj = " + this.idSPLoj + "::idLoja = " + this.idLoja + "::idSP = " + this.idSP +  "}";
    }
}