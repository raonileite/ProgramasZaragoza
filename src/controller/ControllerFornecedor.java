/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOFornecedor;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ModelFornecedor;

/**
 *
 * @author ti.raoni
 */
public class ControllerFornecedor {
    DAOFornecedor dAOFornecedor = new DAOFornecedor();
    
    //salvar um novo usuario no banco
    public boolean salvarFornecedorController(ModelFornecedor modelFornecedor) {
        return this.dAOFornecedor.salvarFornecedorDAO(modelFornecedor);
    }
    
    public boolean excluirFornecedorController (int pForId) throws SQLException{
        return this.dAOFornecedor.excluirFornecedorDAO(pForId);
    }
    
    public boolean alterarFornecedorController (ModelFornecedor ModelFornecedor){
        return this.dAOFornecedor.alterarFornecedorDAO(ModelFornecedor);
    }
    
    public ModelFornecedor retornarFornecedorController (int pForId) throws SQLException{
        return this.dAOFornecedor.retornarFornecedorDAO(pForId);
    }
    
    //retorna para o jft o q escolheu no jcb
    public ModelFornecedor retornarFornecedorController (String pForFornecedor){
        return this.dAOFornecedor.retornarFornecedorDAO(pForFornecedor);
    }
    
    public ArrayList<ModelFornecedor> retornarListaFornecedorController(){
        return this.dAOFornecedor.retornarListaFornecedorDAO();
    } 
}
