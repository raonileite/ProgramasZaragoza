package controller;

import model.ModelSolicitacaoPagamento;
import DAO.DAOSolicitacaoPagamento;
import java.util.ArrayList;

/**
*
* @author Raoni
*/
public class ControllerSolicitacaoPagamento {

    DAOSolicitacaoPagamento dAOSolicitacaoPagamento = new DAOSolicitacaoPagamento();

    /**
    * grava SolicitacaoPagamento
    * @param pModelSolicitacaoPagamento
    * @return int
    */
    public int salvarSolicitacaoPagamentoController(ModelSolicitacaoPagamento modelSolicitacaoPagamento){
        return this.dAOSolicitacaoPagamento.salvarSolicitacaoPagamentoDAO(modelSolicitacaoPagamento);
    }

    /**
    * recupera SolicitacaoPagamento
    * @param pIdSP
    * @return ModelSolicitacaoPagamento
    */
    public ModelSolicitacaoPagamento getSolicitacaoPagamentoController(int pIdSP){
        return this.dAOSolicitacaoPagamento.getSolicitacaoPagamentoDAO(pIdSP);
    }

    /**
    * recupera uma lista deSolicitacaoPagamento
    * @param pIdSP
    * @return ArrayList
    */
    public ArrayList<ModelSolicitacaoPagamento> getListaSolicitacaoPagamentoController(){
        return this.dAOSolicitacaoPagamento.getListaSolicitacaoPagamentoDAO();
    }

    /**
    * atualiza SolicitacaoPagamento
    * @param pModelSolicitacaoPagamento
    * @return boolean
    */
    public boolean atualizarSolicitacaoPagamentoController(ModelSolicitacaoPagamento pModelSolicitacaoPagamento){
        return this.dAOSolicitacaoPagamento.atualizarSolicitacaoPagamentoDAO(pModelSolicitacaoPagamento);
    }

    /**
    * exclui SolicitacaoPagamento
    * @param pIdSP
    * @return boolean
    */
    public boolean excluirSolicitacaoPagamentoController(int pIdSP){
        return this.dAOSolicitacaoPagamento.excluirSolicitacaoPagamentoDAO(pIdSP);
    }
    
}