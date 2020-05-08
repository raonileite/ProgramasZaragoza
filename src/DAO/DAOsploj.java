package DAO;

import model.Modelsploj;
import util.ConexaoSQLite;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
*
* @author raoni
*/
public class DAOsploj extends ConexaoSQLite {

    /**
    * grava sploj
    * @param pModelsploj
    * @return int
    */
    public int salvarsplojDAO(Modelsploj pModelsploj){
        this.conectar();
        String sql = 
            "INSERT INTO tbl_sp_loj ("
                    + "pk_id_sploj,"
                    + "pk_id_loja,"
                    + "pk_id_sp"
                + ") VALUES (?,?,?);"
            ;
        
        try (PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1, pModelsploj.getIdSPLoj());
            preparedStatement.setInt(2, pModelsploj.getIdLoja());
            preparedStatement.setInt(3, pModelsploj.getIdSP());
            return preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.desconectar();
        }

    }
/**
    * recupera sploj
    * @param pIdSPLoj
    * @return Modelsploj
    */
    public Modelsploj getsplojDAO(int pIdSPLoj){
        Modelsploj modelsploj = null;

        String sql = "SELECT "
                    + "pk_id_sploj,"
                    + "pk_id_loja,"
                    + "pk_id_sp"
                 + " FROM"
                     + " tbl_sp_loj"
                 + " WHERE"
                     + " pk_id_sploj = ?"
                + ";"
            ;

        this.conectar();

        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)){
            
            preparedStatement.setInt(1, pIdSPLoj);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {modelsploj = new Modelsploj();
                modelsploj.setIdSPLoj(resultSet.getInt(1));
                modelsploj.setIdLoja(resultSet.getInt(2));
                modelsploj.setIdSP(resultSet.getInt(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.desconectar();
        }
        return modelsploj;
    }

    /**
    * recupera uma lista de sploj
        * @return ArrayList
    */
    public ArrayList<Modelsploj> getListasplojDAO(){
        ArrayList<Modelsploj> listamodelsploj = new ArrayList();
        Modelsploj modelsploj = null;

        String sql = "SELECT "
                    + "pk_id_sploj,"
                    + "pk_id_loja,"
                    + "pk_id_sp"
                 + " FROM"
                     + " tbl_sp_loj"
                + ";";

        this.conectar();

        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelsploj = new Modelsploj();
                modelsploj.setIdSPLoj(resultSet.getInt(1));
                modelsploj.setIdLoja(resultSet.getInt(2));
                modelsploj.setIdSP(resultSet.getInt(3));
                listamodelsploj.add(modelsploj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.desconectar();
        }
        return listamodelsploj;
    }

    /**
    * atualiza sploj
    * @param pModelsploj
    * @return boolean
    */
    public boolean atualizarsplojDAO(Modelsploj pModelsploj){
        this.conectar();
        String sql = 
            "UPDATE tbl_sp_loj SET "
                    + "pk_id_sploj = ?,"
                    + "pk_id_loja = ?,"
                    + "pk_id_sp = ?"
                + " WHERE pk_id_sploj = ? "
                +";"
            ;
        
        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)){
            preparedStatement.setInt(1, pModelsploj.getIdSPLoj());
            preparedStatement.setInt(2, pModelsploj.getIdLoja());
            preparedStatement.setInt(3, pModelsploj.getIdSP());
            preparedStatement.setInt(4, pModelsploj.getIdSPLoj());
            return preparedStatement.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.desconectar();
        }

    }
/**
    * exclui sploj
    * @param pIdSPLoj
    * @return boolean
    */
    public boolean excluirsplojDAO(int pIdSPLoj){
        this.conectar();
        String sql = 
            "DELETE FROM tbl_sp_loj "
                + " WHERE pk_id_sploj = ? "
                +";"
            ;
        
        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)){
            preparedStatement.setInt(1, pIdSPLoj);
            return preparedStatement.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.desconectar();
        }

    }

    public boolean salvarsplojDAO(ArrayList<Modelsploj> pListaModelsploj) throws SQLException {
     this.conectar();
     int cont = pListaModelsploj.size();
     try{
     for(int i =0; i < cont; i++ ){
        String sql = 
            "INSERT INTO tbl_sp_loj ("
                    + "fk_loj_id,"
                    + "fk_sp_id"
                + ") VALUES (?,?);"
            ;
     
         PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, pListaModelsploj.get(i).getIdLoja());
            preparedStatement.setInt(2, pListaModelsploj.get(i).getIdSP());
            preparedStatement.execute();
        
        
        }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.desconectar();
        }
        
    }

}