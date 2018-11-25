/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SisBanco.beans;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */
public class ContaCorrente extends Conta{
    private double chequeEspecial;
    
    public ContaCorrente(){
        this("","","","",0,0);
    }
    
    public ContaCorrente(String numeroConta, String numeroAgencia, String cpf, String tipoConta, double saldo, double chequeEspecial){                
        super.setNumeroConta(numeroConta);
        super.setNumeroAgencia(numeroAgencia);
        super.setCpf(cpf);
        super.setTipoConta(tipoConta);
        super.setSaldo(saldo);
        this.chequeEspecial = chequeEspecial;        
    }
    
    public ContaCorrente(String numeroConta, String cpf, String tipoConta, double saldo){
        super.setNumeroConta(numeroConta);
        super.setCpf(cpf);
        super.setTipoConta(tipoConta);
        super.setSaldo(saldo);
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }
    
    public String getChequeEspecialFmt(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(chequeEspecial);
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    
    public void setChequeEspecial(String chequeEspecial){
        try{
            NumberFormat nf_numero = NumberFormat.getInstance();
            Number nb = nf_numero.parse(chequeEspecial.trim());
            this.chequeEspecial = nb.doubleValue();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
    }     
}

