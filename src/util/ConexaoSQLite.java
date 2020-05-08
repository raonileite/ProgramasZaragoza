/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author ti.raoni
 */
public class ConexaoSQLite {
    private Connection conexao;
    
    public boolean conectar(){
        try {
            String url = "jdbc:sqlite:db/dbsolicitacaopagamento.db";
            this.conexao = DriverManager.getConnection(url);
            System.out.println("Conectado");
        } catch (SQLException e){
         System.err.println(e.getMessage());
         return false;
        }
        return true;
    }
    
    public boolean desconectar() {
        try {
            if (this.conexao.isClosed() == false){
                this.conexao.close();
                System.out.println("Desconectado");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public Statement criarStatement(){
        try{
            return (Statement) this.conexao.createStatement();
        }catch (SQLException e){
            return null;
        }
    }
    
    public PreparedStatement criarPreparedStatement (String pSQL, int RETURN_GENERATED_KEYS){
        try {
            return conexao.prepareStatement (pSQL, RETURN_GENERATED_KEYS);
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            return null;
        }    
    }
    
    public Connection getConexao() throws SQLException{
        //return this.conexao;
        String url = "jdbc:sqlite:db/dbsolicitacaopagamento.db";
        
    try {
        if(conexao==null) // Aqui não funciona, ele sempre pega a con == null 
        {    
        
        conexao = DriverManager.getConnection(url);
        System.out.println("Banco de dados conectado");
        //return con;
        }

    } catch (SQLException e) {
        System.out.println("\nNão foi possível estabelecer conexão com a base de dados.\n");
        e.printStackTrace();
        return null;
        }
    return conexao;
    }
    
    public PreparedStatement criarPreparedStatement (String sql){
        try {
            return this.conexao.prepareStatement (sql);
        } catch (SQLException e) {
            return null;
        }
    }
    
    
}    