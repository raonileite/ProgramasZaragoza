/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ModelUsuario;


/**
 *
 * @author ti.raoni
 */
public class ControllerUsuario {
    DAOUsuario dAOUsuario = new DAOUsuario();
    
    //salvar um novo usuario no banco
    public boolean salvarUsuarioController(ModelUsuario modelUsuario) {
        return this.dAOUsuario.salvarUsuarioDAO(modelUsuario);
    }
    
    public boolean excluirUsuarioController (int pUsuId) throws SQLException{
        return this.dAOUsuario.excluirUsuarioDAO(pUsuId);
    }
    
    public boolean alterarUsuarioController (ModelUsuario ModelUsuario){
        return this.dAOUsuario.alterarUsuarioDAO(ModelUsuario);
    }
    
    public ModelUsuario retornarUsuarioController (int pUsuId) throws SQLException{
        return this.dAOUsuario.retornarUsuarioDAO(pUsuId);
    }
    
    public ArrayList<ModelUsuario> retornarListaUsuarioController(){
        return this.dAOUsuario.retornarListaUsuarioDAO();
    } 

    public boolean getValidarUsuarioController(ModelUsuario pmodelUsuario) throws SQLException {
        return this.dAOUsuario.getValidarUsuarioDAO(pmodelUsuario);
    }
}
