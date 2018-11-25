/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SisBanco.beans;

/**
 *
 * @author Vinicius
 */
public class ContaPoupanca extends Conta{
    private float variacao;
    
    public ContaPoupanca(){
        this("","","","",0,0);
    }
    
    public ContaPoupanca(String numeroConta, String numeroAgencia, String cpf, String tipoConta, double saldo, float variacao){              
        super.setNumeroConta(numeroConta);
        super.setNumeroAgencia(numeroAgencia);
        super.setCpf(cpf);  
        super.setTipoConta(tipoConta);
        super.setSaldo(saldo);
        this.variacao = variacao;
    }

    public float getVariacao() {
        return variacao;
    }

    public void setVariacao(float variacao) {
        this.variacao = variacao;
    }
    
    public void setVariacao(String variacao){
        this.variacao = Float.parseFloat(variacao);
    }    
}
