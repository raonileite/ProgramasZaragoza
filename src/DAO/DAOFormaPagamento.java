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
import model.ModelFormaPagamento;
import util.ConexaoSQLite;

/**
 *
 * @author ti.raoni
 */
public class DAOFormaPagamento extends ConexaoSQLite{
    public boolean salvarFormaPagamentoDAO (ModelFormaPagamento pModelFornecedor){
        conectar();
        // executar sql
        String sql = "INSERT INTO tbl_formpagamento ("
                + "pag_forma) "
                + "VALUES (?)";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, pModelFornecedor.getPagForma());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        desconectar();
        return true;
    }
    
    public boolean excluirFormaPagamentoDAO (int pPagId) throws SQLException{
        conectar();
        String sql = "DELETE FROM tbl_formpagamento WHERE pk_pag_id = '"+pPagId+"'";
        PreparedStatement preparedStatement = criarPreparedStatement (sql);
        try{
            preparedStatement.execute();
        }catch (SQLException ex) {
            Logger.getLogger(DAOFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
        desconectar();
        return true;    
    }
    
    public boolean alterarFormaPagamentoDAO (ModelFormaPagamento pModelFormaPagamento){
        conectar();
        String sql = "UPDATE tbl_formpagamento SET "
                + "pag_forma = ? "
                + "WHERE pk_pag_id = '"+pModelFormaPagamento.getPagId()+"'";
            PreparedStatement preparedStatement = criarPreparedStatement (sql);
        try{
            preparedStatement.setString(1, pModelFormaPagamento.getPagForma());
            preparedStatement.execute();
        }catch (SQLException ex) {
            Logger.getLogger(DAOFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
        desconectar();
        return true; 
    }
    
    public ModelFormaPagamento retornarFormaPagamentoDAO (int pPagId) throws SQLException{
        ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento ();
        this.conectar();
        String sql = "SELECT * FROM tbl_formpagamento WHERE pk_pag_id = '"+pPagId+"';";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);    
        try{
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                modelFormaPagamento.setPagId(rs.getInt(1));
                modelFormaPagamento.setPagForma(rs.getString(2));
            }
            rs.close();
            desconectar();
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }    
        desconectar();
        return modelFormaPagamento;
    }
    public ModelFormaPagamento retornarFormaPagamentoDAO (String pPagForma) throws SQLException{
        ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento ();
        this.conectar();
        String sql = "SELECT * FROM tbl_formpagamento WHERE pag_forma = '"+pPagForma+"';";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);    
        try{
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                modelFormaPagamento.setPagId(rs.getInt(1));
                modelFormaPagamento.setPagForma(rs.getString(2));
            }
            rs.close();
            desconectar();
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }    
        desconectar();
        return modelFormaPagamento;
    }
    
    public ArrayList<ModelFormaPagamento> retornarListaFormaPagamentoDAO(){
        ArrayList<ModelFormaPagamento> listaModelFormaPagamento = new ArrayList<>();
        ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
        try{
            this.conectar();
            String sql = "SELECT * FROM tbl_formpagamento;";
            PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            try{
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                modelFormaPagamento = new ModelFormaPagamento();
                modelFormaPagamento.setPagId(rs.getInt(1));
                modelFormaPagamento.setPagForma(rs.getString(2));
                listaModelFormaPagamento.add(modelFormaPagamento);
            }
            rs.close();
            desconectar();
            }catch (SQLException ex) {
            Logger.getLogger(DAOFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.desconectar();
        }
        return listaModelFormaPagamento;
    
    }
}
