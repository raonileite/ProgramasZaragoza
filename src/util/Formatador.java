/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Raoni
 */
public class Formatador {
    /*
    ********Converter a virgula de uma string para ponto
    Para usar o metodo
    Formatador formatador = new Formatador(); ai importar
    ai lá no metodo salvar na hora de setar a variavel 
    modelProduto.setProValor(formatador.converterVirgulaParaPonto(this.jtfValor.getText()));
    jogar no alterar tbm.
    */
    public Double converterVirgulaParaPonto(String pString){
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i =  0; i < tamanhoString; i++){
            if (pString.charAt(i)== ','){
            retorno += '.';
            }else{
                retorno += pString.charAt(i);
            }
        }
        return Double.parseDouble(retorno);
    }
}
