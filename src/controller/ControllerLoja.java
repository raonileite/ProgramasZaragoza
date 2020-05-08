/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOLoja;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ModelLoja;

/**
 *
 * @author ti.raoni
 */
public class ControllerLoja {
    DAOLoja dAOLoja = new DAOLoja();
    
    //salvar um novo usuario no banco
    public boolean salvarLojaController(ModelLoja modelLoja) {
        return this.dAOLoja.salvarLojaDAO(modelLoja);
    }
    
    public boolean excluirLojaController (int pLojId) throws SQLException{
        return this.dAOLoja.excluirLojaDAO(pLojId);
    }
    
    public boolean alterarLojaController (ModelLoja ModelLoja){
        return this.dAOLoja.alterarLojaDAO(ModelLoja);
    }
    
    public ModelLoja retornarLojaController (int pLojId) throws SQLException{
        return this.dAOLoja.retornarLojaDAO(pLojId);
    }
    
    //retorna para o jft o q escolheu no jcb
    public ModelLoja retornarLojaController (String pLojSigla){
        return this.dAOLoja.retornarLojaDAO(pLojSigla);
    }
    
    public ArrayList<ModelLoja> retornarListaLojaController(){
        return this.dAOLoja.retornarListaLojaDAO();
    } 
}
