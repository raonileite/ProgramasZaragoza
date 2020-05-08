package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ModelSolicitacaoPagamento;
import util.ConexaoSQLite;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
*
* @author Raoni
*/
public class DAOSolicitacaoPagamento extends ConexaoSQLite {

    /**
    * grava SolicitacaoPagamento
    * @param pModelSolicitacaoPagamento
    * @return int
    */
    public int salvarSolicitacaoPagamentoDAO(ModelSolicitacaoPagamento pModelSolicitacaoPagamento){
        try {
            int id = 0;
            this.conectar();
            String sql = "INSERT INTO tbl_solicitacaopagamento ("
                    + "fk_for_id,"
                    + "fk_pag_id,"
                    + "sp_historico,"
                    + "sp_observacoes,"
                    + "sp_valor,"
                    + "sp_data,"
                    + "fk_usu_id,"
                    + "sp_nota"
                + ") VALUES ("
                    + "'" + pModelSolicitacaoPagamento.getIdFornecedor() + "',"
                    + "'" + pModelSolicitacaoPagamento.getIdForma() + "',"
                    + "'" + pModelSolicitacaoPagamento.getSpHistorico() + "',"
                    + "'" + pModelSolicitacaoPagamento.getSpObservacoes() + "',"
                    + "'" + pModelSolicitacaoPagamento.getSpValor() + "',"
                    + "'" + pModelSolicitacaoPagamento.getSpData() + "',"
                    + "'" + pModelSolicitacaoPagamento.getIdUsuario() + "',"
                    + "'" + pModelSolicitacaoPagamento.getSpNota() + "'"
                + ");"
            ;
            PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
           preparedStatement.execute();
           ResultSet rsID = preparedStatement.getGeneratedKeys();
           if (rsID.next()){
               id = rsID.getInt(1);
           }
           return id;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.desconectar();
        }
       
    }

    /**
    * recupera SolicitacaoPagamento
    * @param pIdSP
    * @return ModelSolicitacaoPagamento
    */
    public ModelSolicitacaoPagamento getSolicitacaoPagamentoDAO(int pIdSP){
        ModelSolicitacaoPagamento modelSolicitacaoPagamento = new ModelSolicitacaoPagamento();
        try {
            this.conectar();
            String sql = 
                "SELECT "
                    + "pk_id_sp,"
                    + "fk_id_loja,"
                    + "fk_id_fornecedor,"
                    + "fk_id_forma,"
                    + "sp_historico,"
                    + "sp_observacoes,"
                    + "sp_valor,"
                    + "sp_data,"
                    + "fk_id_usuario,"
                    + "sp_nota"
                 + " FROM"
                     + " tbl_solicitacaopagamento"
                 + " WHERE"
                     + " pk_id_sp = '" + pIdSP + "'"
                + ";"
            ;
            PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);  
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                modelSolicitacaoPagamento.setIdSP(rs.getInt(1));
                modelSolicitacaoPagamento.setIdLoja(rs.getInt(2));
                modelSolicitacaoPagamento.setIdFornecedor(rs.getInt(3));
                modelSolicitacaoPagamento.setIdForma(rs.getInt(4));
                modelSolicitacaoPagamento.setSpHistorico(rs.getString(5));
                modelSolicitacaoPagamento.setSpObservacoes(rs.getString(6));
                modelSolicitacaoPagamento.setSpValor(rs.getDouble(7));
                modelSolicitacaoPagamento.setSpData(rs.getDate(8));
                modelSolicitacaoPagamento.setIdUsuario(rs.getInt(9));
                modelSolicitacaoPagamento.setSpNota(rs.getInt(10));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            desconectar();
        }
        return modelSolicitacaoPagamento;
    }

    /**
    * recupera uma lista de SolicitacaoPagamento
        * @return ArrayList
    */
    public ArrayList<ModelSolicitacaoPagamento> getListaSolicitacaoPagamentoDAO(){
        ArrayList<ModelSolicitacaoPagamento> listamodelSolicitacaoPagamento = new ArrayList();
        ModelSolicitacaoPagamento modelSolicitacaoPagamento = new ModelSolicitacaoPagamento();
        try {
            this.conectar();
            String sql =
                "SELECT "
                    + "pk_sp_id,"
                    + "fk_loj_id,"
                    + "fk_for_id,"
                    + "fk_pag_id,"
                    + "sp_historico,"
                    + "sp_observacoes,"
                    + "sp_valor,"
                    + "sp_data,"
                    + "fk_usu_id,"
                    + "sp_nota"
                 + " FROM"
                     + " tbl_solicitacaopagamento"
                + ";"
            ;
            PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                modelSolicitacaoPagamento = new ModelSolicitacaoPagamento();
                modelSolicitacaoPagamento.setIdSP(rs.getInt(1));
                modelSolicitacaoPagamento.setIdLoja(rs.getInt(2));
                modelSolicitacaoPagamento.setIdFornecedor(rs.getInt(3));
                modelSolicitacaoPagamento.setIdForma(rs.getInt(4));
                modelSolicitacaoPagamento.setSpHistorico(rs.getString(5));
                modelSolicitacaoPagamento.setSpObservacoes(rs.getString(6));
                modelSolicitacaoPagamento.setSpValor(rs.getDouble(7));
                //modelSolicitacaoPagamento.setSpData(rs.getDate(8));
                modelSolicitacaoPagamento.setIdUsuario(rs.getInt(9));
                modelSolicitacaoPagamento.setSpNota(rs.getInt(10));
                listamodelSolicitacaoPagamento.add(modelSolicitacaoPagamento);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            desconectar();
        }
        return listamodelSolicitacaoPagamento;
    }

    /**
    * atualiza SolicitacaoPagamento
    * @param pModelSolicitacaoPagamento
    * @return boolean
    */
  /*  public ArrayList<ModelSolicitacaoPagamento> getListaSolicitacaoPagamentoDAO(){
        ArrayList<ModelSolicitacaoPagamento> listamodelSolicitacaoPagamento = new ArrayList();
        ModelSolicitacaoPagamento modelSolicitacaoPagamento = new ModelSolicitacaoPagamento();
        try {
            this.conectar();
            String sql =
                    "SELECT "
                    + "tbl_solicitacaopagamento.pk_sp_id,"
                    + "tbl_solicitacaopagamento.sp_historico,"
                    + "tbl_solicitacaopagamento.sp_observacoes,"
                    + "tbl_solicitacaopagamento.sp_valor,"
                    + "tbl_solicitacaopagamento.sp_data,"
                    + "tbl_solicitacaopagamento.sp_nota,"
                    + "tbl_formpagamento.pag_forma,"
                    + "tbl_fornecedor.for_nome"
                    + "FROM "
                    + "tbl_solicitacaopagamento"
                    + "INNER JOIN tbl_formpagamento ON "
                    + "tbl_formpagamento.pk_pag_id = tbl_solicitacaopagamento.fk_pag_id "
                    + "INNER JOIN tbl_fornecedor ON "
                    + "tbl_fornecedor.pk_for_id = tbl_solicitacaopagamento.fk_for_id "
                    + ";"
            ;
            PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                modelSolicitacaoPagamento = new ModelSolicitacaoPagamento();
                modelSolicitacaoPagamento.setIdSP(rs.getInt(1));
                modelSolicitacaoPagamento.setSpHistorico(rs.getString(2));
                modelSolicitacaoPagamento.setSpObservacoes(rs.getString(3));
                modelSolicitacaoPagamento.setSpValor(rs.getDouble(4));
                //modelSolicitacaoPagamento.setSpData(rs.getDate(5));
                modelSolicitacaoPagamento.setSpNota(rs.getInt(6));
                modelSolicitacaoPagamento.setIdForma(rs.getInt(7));
                modelSolicitacaoPagamento.setIdFornecedor(rs.getInt(8));
                
                listamodelSolicitacaoPagamento.add(modelSolicitacaoPagamento);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            desconectar();
        }
        return listamodelSolicitacaoPagamento;
    }*/
    public boolean atualizarSolicitacaoPagamentoDAO(ModelSolicitacaoPagamento pModelSolicitacaoPagamento){
        try {
            this.conectar();
            String sql =
                "UPDATE tbl_solicitacaopagamento SET "
                    + "fk_id_loja = '" + pModelSolicitacaoPagamento.getIdLoja() + "',"
                    + "fk_id_fornecedor = '" + pModelSolicitacaoPagamento.getIdFornecedor() + "',"
                    + "fk_id_forma = '" + pModelSolicitacaoPagamento.getIdForma() + "',"
                    + "sp_historico = '" + pModelSolicitacaoPagamento.getSpHistorico() + "',"
                    + "sp_observacoes = '" + pModelSolicitacaoPagamento.getSpObservacoes() + "',"
                    + "sp_valor = '" + pModelSolicitacaoPagamento.getSpValor() + "',"
                    + "sp_data = '" + pModelSolicitacaoPagamento.getSpData() + "',"
                    + "fk_id_usuario = '" + pModelSolicitacaoPagamento.getIdUsuario() + "',"
                    + "sp_nota = '" + pModelSolicitacaoPagamento.getSpNota() + "'"
                + " WHERE "
                    + "pk_id_sp = '" + pModelSolicitacaoPagamento.getIdSP() + "'"
                + ";"
            ;
            PreparedStatement preparedStatement = criarPreparedStatement (sql);
            preparedStatement.execute();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            desconectar();
        }
        return true;
    }

    /**
    * exclui SolicitacaoPagamento
    * @param pIdSP
    * @return boolean
    */
    public boolean excluirSolicitacaoPagamentoDAO(int pIdSP){
        try {
            this.conectar();
            String sql =
                "DELETE FROM tbl_solicitacaopagamento "
                + " WHERE "
                    + "pk_id_sp = '" + pIdSP + "'"
                + ";"
            ;
            PreparedStatement preparedStatement = criarPreparedStatement (sql);
            preparedStatement.execute();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            desconectar();
        }
        return true;
    }
    
   
}