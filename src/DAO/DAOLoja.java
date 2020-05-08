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
import model.ModelLoja;
import util.ConexaoSQLite;

/**
 *
 * @author ti.raoni
 */
public class DAOLoja extends ConexaoSQLite {
    
    public boolean salvarLojaDAO (ModelLoja pModelLoja){
        conectar();
        // executar sql
        String sql = "INSERT INTO tbl_lojas ("
                + "pk_loj_id,"
                + "loj_sigla, "
                + "loj_cidade) "
                + "VALUES (?,?,?)";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setInt(1, pModelLoja.getLojId());
            preparedStatement.setString(2, pModelLoja.getLojSigla());
            preparedStatement.setString(3, pModelLoja.getLojCidade());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOLoja.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        desconectar();
        return true;
    }
    
    public boolean excluirLojaDAO (int pLojId) throws SQLException{
        conectar();
        String sql = "DELETE FROM tbl_lojas WHERE pk_loj_id = '"+pLojId+"'";
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
    
    public boolean alterarLojaDAO (ModelLoja pModelLoja){
        conectar();
        String sql = "UPDATE tbl_lojas SET "
                + "pk_loj_id = ?,"
                + "loj_sigla = ?,"
                + "loj_cidade = ?"
                + "WHERE pk_loj_id = '"+pModelLoja.getLojId()+"'";
            PreparedStatement preparedStatement = criarPreparedStatement (sql);
        try{
            preparedStatement.setInt(1, pModelLoja.getLojId());
            preparedStatement.setString(2, pModelLoja.getLojSigla());
            preparedStatement.setString(3, pModelLoja.getLojCidade());
            preparedStatement.execute();
        }catch (SQLException ex) {
            Logger.getLogger(DAOLoja.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
        desconectar();
        return true; 
    }
    
    public ModelLoja retornarLojaDAO (int pLojId) throws SQLException{
        ModelLoja modelLoja = new ModelLoja ();
        this.conectar();
        String sql = "SELECT * FROM tbl_lojas WHERE pk_loj_id = '"+pLojId+"';";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);    
        try{
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                modelLoja.setLojId(rs.getInt(1));
                modelLoja.setLojSigla(rs.getString(2));
                modelLoja.setLojCidade(rs.getString(3));
            }
            rs.close();
            desconectar();
        }catch (SQLException ex) {
            Logger.getLogger(DAOLoja.class.getName()).log(Level.SEVERE, null, ex);
        }    
        desconectar();
        return modelLoja;
    }
    
    //retorna para o jft o q escolheu no jcb
    public ModelLoja retornarLojaDAO (String pLojSigla){
        ModelLoja modelLoja = new ModelLoja ();
        this.conectar();
        String sql = "SELECT * FROM tbl_lojas WHERE loj_sigla = '"+pLojSigla+"';";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);    
        try{
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                modelLoja.setLojId(rs.getInt(1));
                modelLoja.setLojSigla(rs.getString(2));
                modelLoja.setLojCidade(rs.getString(3));
            }
            rs.close();
            desconectar();
        }catch (SQLException ex) {
            Logger.getLogger(DAOLoja.class.getName()).log(Level.SEVERE, null, ex);
        }    
        desconectar();
        return modelLoja;
    }
    
    public ArrayList<ModelLoja> retornarListaLojaDAO(){
        ArrayList<ModelLoja> listaModelLoja = new ArrayList<>();
        ModelLoja modelLoja = new ModelLoja();
        try{
            this.conectar();
            String sql = "SELECT * FROM tbl_lojas;";
            PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            try{
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                modelLoja = new ModelLoja();
                modelLoja.setLojId(rs.getInt(1));
                modelLoja.setLojSigla(rs.getString(2));
                modelLoja.setLojCidade(rs.getString(3));
                listaModelLoja.add(modelLoja);
            }
            rs.close();
            desconectar();
            }catch (SQLException ex) {
            Logger.getLogger(DAOLoja.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.desconectar();
        }
        return listaModelLoja;
    
    }
    
}
