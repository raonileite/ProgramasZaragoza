/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOFormaPagamento;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ModelFormaPagamento;

/**
 *
 * @author ti.raoni
 */
public class ControllerFormaPagamento {
    DAOFormaPagamento dAOFormaPagamento = new DAOFormaPagamento();
    
    //salvar um novo usuario no banco
    public boolean salvarFormaPagamentoController(ModelFormaPagamento modelFormaPagamento) {
        return this.dAOFormaPagamento.salvarFormaPagamentoDAO(modelFormaPagamento);
    }
    
    public boolean excluirFormaPagamentoController (int pPagId) throws SQLException{
        return this.dAOFormaPagamento.excluirFormaPagamentoDAO(pPagId);
    }
    
    public boolean alterarFormaPagamentoController (ModelFormaPagamento ModelFormaPagamento){
        return this.dAOFormaPagamento.alterarFormaPagamentoDAO(ModelFormaPagamento);
    }
    
    public ModelFormaPagamento retornarFormaPagamentoController (int pPagId) throws SQLException{
        return this.dAOFormaPagamento.retornarFormaPagamentoDAO(pPagId);
    }
     public ModelFormaPagamento retornarFormaPagamentoController (String pPagForma) throws SQLException{
        return this.dAOFormaPagamento.retornarFormaPagamentoDAO(pPagForma);
    }
    
    public ArrayList<ModelFormaPagamento> retornarListaFormaPagamentoController(){
        return this.dAOFormaPagamento.retornarListaFormaPagamentoDAO();
    } 
}
