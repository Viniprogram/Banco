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
public abstract class Conta {        
    private String numeroConta;
    private String numeroAgencia;
    private String cpf;
    private String tipoConta;
    private double saldo;  
    private double deposito;
    private double saque;
    private double transferencia;
    private String senha;
    private String agenciaDestino;
    private String contaDestino;

    public String getCpf() {
        return cpf;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }    
    
    public String getSaldoFmt(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(saldo);
    }

    public String getSenha() {
        return senha;
    }

    public String getAgenciaDestino() {
        return agenciaDestino;
    }

    public String getContaDestino() {
        return contaDestino;
    }
    
    public double getDeposito() {
        return deposito;
    }

    public double getSaque() {
        return saque;
    }

    public double getTransferencia() {
        return transferencia;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }   

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }    

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void setSaldo(double saldo) {        
        this.saldo = saldo;
    }
    
    public void setSaldo(String saldo){
        try{
            NumberFormat nf_numero = NumberFormat.getInstance();
            Number nb = nf_numero.parse(saldo.trim());
            this.saldo = nb.doubleValue();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
}

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAgenciaDestino(String agenciaDestino) {
        this.agenciaDestino = agenciaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }
    
    public void setDeposito(String deposito){
        try{
            NumberFormat nf_numero = NumberFormat.getInstance();
            Number nb = nf_numero.parse(deposito.trim());
            this.deposito = nb.doubleValue();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
}

    public void setSaque(double saque) {
        this.saque = saque;
    }
    
    public void setSaque(String saque){
        try{
            NumberFormat nf_numero = NumberFormat.getInstance();
            Number nb = nf_numero.parse(saque.trim());
            this.saque = nb.doubleValue();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
}

    public void setTransferencia(double transferencia) {
        this.transferencia = transferencia;
    }
    
    public void setTransferencia(String transferencia){
        try{
            NumberFormat nf_numero = NumberFormat.getInstance();
            Number nb = nf_numero.parse(transferencia.trim());
            this.transferencia = nb.doubleValue();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
}
    
    //método saque
    public void saque(String contaOrigem, double valorSaque){        
        if(this.getNumeroConta().equalsIgnoreCase(contaOrigem) && this.getSaldo() >= valorSaque){
            double novoSaldo = this.getSaldo() - valorSaque;
            this.setSaldo(novoSaldo);             
        }                
    }
    
    //método deposito
    public double deposito(String agenciaDestino, String contaDestino, double valorDeposito){
        System.out.println(agenciaDestino + " - " + contaDestino + " - " + valorDeposito);
        System.out.println(this.numeroAgencia + " - " + this.numeroConta + " - " + this.saldo);
        double novoSaldo = 0;
        if(this.numeroAgencia.equalsIgnoreCase(agenciaDestino) && this.numeroConta.equalsIgnoreCase(contaDestino) 
                && valorDeposito > 0){                
            novoSaldo = this.getSaldo() + valorDeposito;            
        }
        else
            JOptionPane.showMessageDialog(null, "Dados para depósito inválidos. Digite novamente.", "Erro", 0);
        return novoSaldo;
    }
    
    
    public void transferencia(String agenciaDestino, String contaOrigem, String contaDestino, double valorTransferencia) {        
        if(valorTransferencia <= this.getSaldo() && valorTransferencia > 0){            
           saque(contaOrigem, valorTransferencia);
           deposito(agenciaDestino, contaDestino, valorTransferencia);
        }
    }

    @Override
    public String toString() {
        return cpf;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (this.numeroConta != other.numeroConta) {
            return false;
        }
        return true;
    }    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }   
}
