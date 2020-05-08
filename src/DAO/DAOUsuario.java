/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.ModelUsuario;
import util.ConexaoSQLite;

/**
 *
 * @author ti.raoni
 */
public class DAOUsuario extends ConexaoSQLite {
    
    public boolean salvarUsuarioDAO (ModelUsuario pModelUsuario){
        conectar();
        // executar sql
        String sql = "INSERT INTO tbl_usuario ("
                + "usu_nome, "
                + "usu_login, "
                + "usu_senha) "
                + "VALUES (?,?,?)";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, pModelUsuario.getUsuNome());
            preparedStatement.setString(2, pModelUsuario.getUsuLogin());
            preparedStatement.setString(3, pModelUsuario.getUsuSenha());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        desconectar();
        return true;
    } 
   
    public boolean excluirUsuarioDAO (int pUsuId) throws SQLException{
        conectar();
        String sql = "DELETE FROM tbl_usuario WHERE pk_usu_id = '"+pUsuId+"'";
        PreparedStatement preparedStatement = criarPreparedStatement (sql);
        try{
            preparedStatement.execute();
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
        desconectar();
        return true;    
    }
    
    public boolean alterarUsuarioDAO (ModelUsuario pModelUsuario){
        conectar();
        String sql = "UPDATE tbl_usuario SET "
                + "usu_nome = ?,"
                + "usu_login = ?,"
                + "usu_senha = ?"
                + "WHERE pk_usu_id = '"+pModelUsuario.getUsuId()+"'";
            PreparedStatement preparedStatement = criarPreparedStatement (sql);
        try{
            preparedStatement.setString(1, pModelUsuario.getUsuNome());
            preparedStatement.setString(2, pModelUsuario.getUsuLogin());
            preparedStatement.setString(3, pModelUsuario.getUsuSenha());
            preparedStatement.execute();
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
        desconectar();
        return true; 
    }
    
    public ModelUsuario retornarUsuarioDAO (int pUsuId) throws SQLException{
        ModelUsuario modelUsuario = new ModelUsuario ();
        this.conectar();
        String sql = "SELECT * FROM tbl_usuario WHERE pk_usu_id = '"+pUsuId+"';";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);    
        try{
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                modelUsuario.setUsuId(rs.getInt(1));
                modelUsuario.setUsuNome(rs.getString(2));
                modelUsuario.setUsuLogin(rs.getString(3));
                modelUsuario.setUsuSenha(rs.getString(4));
            }
            rs.close();
            desconectar();
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }    
        desconectar();
        return modelUsuario;
    }
    
    public ArrayList<ModelUsuario> retornarListaUsuarioDAO(){
        ArrayList<ModelUsuario> listaModelUsuario = new ArrayList<>();
        ModelUsuario modelUsuario = new ModelUsuario();
        try{
            this.conectar();
            String sql = "SELECT * FROM tbl_usuario;";
            PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            try{
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setUsuId(rs.getInt(1));
                modelUsuario.setUsuNome(rs.getString(2));
                modelUsuario.setUsuLogin(rs.getString(3));
                modelUsuario.setUsuSenha(rs.getString(4));
                listaModelUsuario.add(modelUsuario);
            }
            rs.close();
            desconectar();
            }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.desconectar();
        }
        return listaModelUsuario;
    
    }

    public boolean getValidarUsuarioDAO(ModelUsuario pmodelUsuario) throws SQLException {
        
        String pLogin = pmodelUsuario.getUsuLogin();
        String pSenha = pmodelUsuario.getUsuSenha();
       try{
           this.conectar();
            String sql = "select * from tbl_usuario where usu_login = '"+ pmodelUsuario.getUsuLogin() +"' and usu_senha = '"+ pmodelUsuario.getUsuSenha() +"'";
            PreparedStatement preparedStatement = criarPreparedStatement(sql);    
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return true;
                
                }else{
                return false;
                }
            
            
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            desconectar();
        }
        
        desconectar();   
        return false;
    }
}
