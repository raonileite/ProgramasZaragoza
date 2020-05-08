package controller;

import model.Modelsploj;
import DAO.DAOsploj;
import java.sql.SQLException;
import java.util.ArrayList;

/**
*
* @author raoni
*/
public class Controllersploj {

    private DAOsploj daosploj = new DAOsploj();

    /**
    * grava sploj
    * @param pModelsploj
    * @return int
    */
    public int salvarsplojController(Modelsploj pModelsploj){
        return this.daosploj.salvarsplojDAO(pModelsploj);
    }

    /**
    * recupera sploj
    * @param pIdSPLoj
    * @return Modelsploj
    */
    public Modelsploj getsplojController(int pIdSPLoj){
        return this.daosploj.getsplojDAO(pIdSPLoj);
    }

    /**
    * recupera uma lista desploj
    * @param pIdSPLoj
    * @return ArrayList
    */
    public ArrayList<Modelsploj> getListasplojController(){
        return this.daosploj.getListasplojDAO();
    }

    /**
    * atualiza sploj
    * @param pModelsploj
    * @return boolean
    */
    public boolean atualizarsplojController(Modelsploj pModelsploj){
        return this.daosploj.atualizarsplojDAO(pModelsploj);
    }

    /**
    * exclui sploj
    * @param pIdSPLoj
    * @return boolean
    */
    public boolean excluirsplojController(int pIdSPLoj){
        return this.daosploj.excluirsplojDAO(pIdSPLoj);
    }
    
    //salva a lista de loja na sp
    public boolean salvarsplojController(ArrayList<Modelsploj> pListaModelsploj) throws SQLException {
        return this.daosploj.salvarsplojDAO(pListaModelsploj);
    }
}