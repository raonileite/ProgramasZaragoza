/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOSolicitacaoPagamento;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Integer.toString;
import static java.lang.Integer.toString;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import model.ModelSolicitacaoPagamento;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import util.ConexaoSQLite;

/**
 *
 * @author Raoni
 */
public class ControllerRelatorioLoja extends ConexaoSQLite {
    ModelSolicitacaoPagamento modelSolicitacaoPagamento = new ModelSolicitacaoPagamento();
    DAOSolicitacaoPagamento dAOSolicitacaoPagamento = new DAOSolicitacaoPagamento();
    
   public void relatorioJasper() throws JRException, SQLException, FileNotFoundException, IOException{
        String rel = "relatorio/Blank_A4.jasper";
        Connection con = new ConexaoSQLite().getConexao();
        try{
        //JasperReport jr = JasperCompileManager.compileReport(rel);
        JasperPrint jp=JasperFillManager.fillReport(rel,null,con);
        JasperViewer.viewReport(jp,false);
        //para salvar em pdf    
        //JasperExportManager.exportReportToPdfFile(jp,"RelatorioTeste.pdf");
        con.close();
      }catch(Exception erro)
    {
        JOptionPane.showMessageDialog(null,"Não foi possivel gerar relatório!"+erro);
    } 
    }

    public void relatorioSP(int pk) throws JRException, SQLException, FileNotFoundException, IOException{
       String rel = "relatorio/TesteSP.jasper";
        System.out.println(pk);
        HashMap<String,Object> param = new HashMap<String,Object>();
        param.put("SP_ID",pk);
        Connection con = new ConexaoSQLite().getConexao();
      try{
        //JasperReport jr = JasperCompileManager.compileReport(rel);
        JasperPrint jp=JasperFillManager.fillReport(rel,param,con);
        JasperViewer.viewReport(jp,false);
        //para salvar em pdf    
        //JasperExportManager.exportReportToPdfFile(jp,"RelatorioTeste.pdf");
        con.close();
      }catch(Exception erro)
    {
        JOptionPane.showMessageDialog(null,"Não foi possivel gerar relatório!"+erro);
    } 
    }
   
}
