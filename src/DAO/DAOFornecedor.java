/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelFornecedor;
import util.ConexaoSQLite;

/**
 *
 * @author ti.raoni
 */
public class DAOFornecedor extends ConexaoSQLite {
    public boolean salvarFornecedorDAO (ModelFornecedor pModelFornecedor){
        conectar();
        // executar sql
        String sql = "INSERT INTO tbl_fornecedor ("
                + "for_nome, "
                + "for_descricao) "
                + "VALUES (?,?)";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, pModelFornecedor.getForFornecedor());
            preparedStatement.setString(2, pModelFornecedor.getForDescricao());
                        
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        desconectar();
        return true;
    } 
    
    public boolean excluirFornecedorDAO (int pForId) throws SQLException{
        conectar();
        String sql = "DELETE FROM tbl_fornecedor WHERE pk_for_id = '"+pForId+"'";
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
    
    public boolean alterarFornecedorDAO (ModelFornecedor pModelFornecedor){
        conectar();
        String sql = "UPDATE tbl_fornecedor SET "
                + "for_nome = ?,"
                + "for_descricao = ?"
                + "WHERE pk_for_id = '"+pModelFornecedor.getForId()+"'";
            PreparedStatement preparedStatement = criarPreparedStatement (sql);
        try{
            preparedStatement.setString(1, pModelFornecedor.getForFornecedor());
            preparedStatement.setString(2, pModelFornecedor.getForDescricao());
            preparedStatement.execute();
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
        desconectar();
        return true; 
    }
    
    public ModelFornecedor retornarFornecedorDAO (int pForId) throws SQLException{
        ModelFornecedor modelFornecedor = new ModelFornecedor ();
        this.conectar();
        String sql = "SELECT * FROM tbl_fornecedor WHERE pk_For_id = '"+pForId+"';";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);    
        try{
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                modelFornecedor.setForId(rs.getInt(1));
                modelFornecedor.setForFornecedor(rs.getString(2));
                modelFornecedor.setForDescricao(rs.getString(3));
               
            }
            rs.close();
            desconectar();
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }    
        desconectar();
        return modelFornecedor;
    }
    
    //retorna para o jft o q escolheu no jcb
    public ModelFornecedor retornarFornecedorDAO (String pForFornecedor){
        ModelFornecedor modelFornecedor = new ModelFornecedor ();
        this.conectar();
        String sql = "SELECT * FROM tbl_fornecedor WHERE for_nome = '"+pForFornecedor+"';";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);    
        try{
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                modelFornecedor.setForId(rs.getInt(1));
                modelFornecedor.setForFornecedor(rs.getString(2));
                modelFornecedor.setForDescricao(rs.getString(3));
               
            }
            rs.close();
            desconectar();
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }    
        desconectar();
        return modelFornecedor;
    }
    
    public ArrayList<ModelFornecedor> retornarListaFornecedorDAO(){
        ArrayList<ModelFornecedor> listaModelFornecedor = new ArrayList<>();
        ModelFornecedor modelFornecedor = new ModelFornecedor();
        try{
            this.conectar();
            String sql = "SELECT * FROM tbl_fornecedor;";
            PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            try{
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                modelFornecedor = new ModelFornecedor();
                modelFornecedor.setForId(rs.getInt(1));
                modelFornecedor.setForFornecedor(rs.getString(2));
                modelFornecedor.setForDescricao(rs.getString(3));
                listaModelFornecedor.add(modelFornecedor);
            }
            rs.close();
            desconectar();
            }catch (SQLException ex) {
            Logger.getLogger(DAOFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.desconectar();
        }
        return listaModelFornecedor;
    
    }
}
