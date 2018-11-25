/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SisBanco.dao;

import br.com.SisBanco.accessories.ConexaoSisbanco;
import br.com.SisBanco.beans.Conta;
import br.com.SisBanco.beans.ContaCorrente;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius
 */
public class ContaDAO {
    private ConexaoSisbanco cs;    

    public ContaDAO() throws Exception{
        cs = new ConexaoSisbanco();        
    }
    
    public void cadastrarConta(Conta c)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("INSERT INTO CONTA (NUMERO_CONTA, NUM_AGENCIA, ID_CPF, TIPO_CONTA, SALDO, SENHA) VALUES (?,?,?,?,?,?)", 
                Statement.RETURN_GENERATED_KEYS);
        if(c.getNumeroConta().equalsIgnoreCase("_____-__")){
           JOptionPane.showMessageDialog(null, "Conta inválida! Informe um número válido!", "Erro", 0); 
           return;
        }
        else            
        pst.setString(1, c.getNumeroConta());        
        pst.setString(2, c.getNumeroAgencia());
        pst.setString(3, c.getCpf());
        pst.setString(4, c.getTipoConta());
        if(c.getSaldo() <= 0){                       
            JOptionPane.showMessageDialog(null, "Saldo inicial deve ser maior que zero!", "Erro", 0); 
            return;
        }
        else       
        pst.setDouble(5, c.getSaldo());
        pst.setString(6, c.getSenha());
        pst.executeUpdate();
        cs.confirmarTransacao();
        pst.close();
    }
    
    public void alterarConta(Conta c)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("UPDATE CONTA SET TIPO_CONTA = ?, SALDO = ? WHERE NUMERO_CONTA = ?");
        pst.setString(1, c.getTipoConta());
        pst.setDouble(2, c.getSaldo());
        pst.setString(3, c.getNumeroConta());
        pst.executeUpdate();
        pst.close();
        cs.confirmarTransacao();
    }
    
    public Conta consultarConta(String numeroConta)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("SELECT * FROM CONTA WHERE NUMERO_CONTA = ?");
        pst.setString(1, numeroConta);
        ResultSet rs = pst.executeQuery(); 
        if(!rs.next()) return null;
        return new ContaCorrente(rs.getString("NUM_AGENCIA"), rs.getString("TIPO_CONTA"), rs.getString("ID_CPF"), rs.getString("NUMERO_CONTA"), rs.getDouble("SALDO"), rs.getDouble("CHEQUE_ESPECIAL"));
    }
    
    public void excluirConta(String numeroConta)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("DELETE FROM CONTA WHERE NUMERO_CONTA = ?");
        pst.setString(1, numeroConta);
        pst.executeUpdate();
        pst.close();
        cs.confirmarTransacao();       
    }
    
    public ResultSet carregarGrade()throws Exception{
      Statement stm = cs.getConexao().createStatement();
      return stm.executeQuery("SELECT NUM_AGENCIA, NUMERO_CONTA, ID_CPF, TIPO_CONTA, SALDO FROM CONTA ORDER BY TIPO_CONTA");
    }  
    
    public void depositar(Conta c)throws Exception{                
        double novoSaldo = 0;
        String contaBanco = "", agenciaBanco = "";
        PreparedStatement pst = cs.getConexao().prepareStatement("SELECT NUMERO_CONTA, NUM_AGENCIA, SALDO FROM CONTA WHERE NUMERO_CONTA = ? AND NUM_AGENCIA = ?");
        pst.setString(1, c.getNumeroConta());
        pst.setString(2, c.getNumeroAgencia());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
              contaBanco = rs.getString("NUMERO_CONTA");
              agenciaBanco = rs.getString("NUM_AGENCIA");
              novoSaldo = rs.getDouble("SALDO");               
        } 
        
        if(!contaBanco.equalsIgnoreCase(c.getNumeroConta()) && !agenciaBanco.equalsIgnoreCase(c.getNumeroAgencia())){
            JOptionPane.showMessageDialog(null, "Dados para depósito inválidos!", "Erro", 0);
            return;
        }
        else if(c.getDeposito() > 0){
            novoSaldo +=  c.getDeposito();
            JOptionPane.showMessageDialog(null, "Depósito confirmado!", "Mensagem", 1);
        }
        else{
           JOptionPane.showMessageDialog(null, "Valor para depósito deve ser maior que zero.", "Erro", 0); 
           return;
        }
        
        pst = cs.getConexao().prepareStatement("UPDATE CONTA SET SALDO =" + novoSaldo + "WHERE NUMERO_CONTA = ? AND NUM_AGENCIA = ?");         
        pst.setString(1, c.getNumeroConta());
        pst.setString(2, c.getNumeroAgencia());        
        pst.executeUpdate();
        pst.close();
        cs.confirmarTransacao();
    } 
        
    public void sacar(Conta c)throws Exception{ 
        double novoSaldo = 0;
        String contaBanco = "", agenciaBanco = "", senhaBanco = "", mensagem  = "";
        PreparedStatement pst = cs.getConexao().prepareStatement("SELECT NUMERO_CONTA, NUM_AGENCIA, SALDO, SENHA FROM CONTA WHERE NUMERO_CONTA = ?"
                + " AND NUM_AGENCIA = ? AND SENHA = ?");
        pst.setString(1, c.getNumeroConta());
        pst.setString(2, c.getNumeroAgencia());
        pst.setString(3, c.getSenha());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
              contaBanco = rs.getString("NUMERO_CONTA");
              agenciaBanco = rs.getString("NUM_AGENCIA");
              novoSaldo = rs.getDouble("SALDO"); 
              senhaBanco = rs.getString("SENHA");
        }         
                
        if(!contaBanco.equalsIgnoreCase(c.getNumeroConta()) || !agenciaBanco.equalsIgnoreCase(c.getNumeroAgencia())){
            JOptionPane.showMessageDialog(null,"Dados para saque inválidos!" , "Erro", 0);            
        } 
        else if(!senhaBanco.equalsIgnoreCase(c.getSenha())){
            JOptionPane.showMessageDialog(null,"Senha inválida!" , "Erro", 0);
        }
        else if(novoSaldo <= 0){
            JOptionPane.showMessageDialog(null,"Saldo insuficiente!" , "Erro", 0);
        }       
        else if(c.getSaque() % 20.0 == 0){
            novoSaldo -= c.getSaque();
            JOptionPane.showMessageDialog(null,"Saque confirmado!" , "Mensagem", 1);
        }  
        else if(c.getSaque() % 50.0 == 0){
            novoSaldo -= c.getSaque();
            JOptionPane.showMessageDialog(null,"Saque confirmado!" , "Mensagem", 1);
        } 
        else if(c.getSaque() % 70.0 == 0){
            novoSaldo -= c.getSaque();
            JOptionPane.showMessageDialog(null,"Saque confirmado!" , "Mensagem", 1);
        }         
        else{           
           JOptionPane.showMessageDialog(null,"Notas disponíveis: 20 e 50 reais.", "Erro", 0);          
        }   
        
         
         
        
        pst = cs.getConexao().prepareStatement("UPDATE CONTA SET SALDO =" + novoSaldo + "WHERE NUMERO_CONTA = ? AND NUM_AGENCIA = ? AND SENHA = ?");         
        pst.setString(1, c.getNumeroConta());
        pst.setString(2, c.getNumeroAgencia());
        pst.setString(3, c.getSenha());
        pst.executeUpdate();
        pst.close();
        cs.confirmarTransacao();        
    } 
        //método que confere os dados da agência e conta destino antes de habilitar o saque para a transferência
    public boolean confereDadosContaDestino(Conta c)throws Exception{
        String contaDepositoBanco = "", agenciaDepositoBanco = "";
        PreparedStatement pst = cs.getConexao().prepareStatement("SELECT NUMERO_CONTA, NUM_AGENCIA FROM CONTA WHERE NUMERO_CONTA = ? AND NUM_AGENCIA = ?");
        pst.setString(1, c.getContaDestino());
        pst.setString(2, c.getAgenciaDestino());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
              contaDepositoBanco = rs.getString("NUMERO_CONTA");
              agenciaDepositoBanco = rs.getString("NUM_AGENCIA");                             
        } 
            
        if(contaDepositoBanco.equalsIgnoreCase(c.getContaDestino()) && agenciaDepositoBanco.equalsIgnoreCase(c.getAgenciaDestino())){ 
            return true;
        }    
        else{                 
            return false;    
        }
    }
    
    public void transferir(Conta c)throws Exception{ 
        boolean confere = confereDadosContaDestino(c);
        
        //realiza saque para a transferência
        if(confere == true){
            double novoSaldo = 0;
            String contaBanco = "", agenciaBanco = "", senhaBanco = "";
            PreparedStatement pst = cs.getConexao().prepareStatement("SELECT NUMERO_CONTA, NUM_AGENCIA, SALDO, SENHA FROM CONTA WHERE NUMERO_CONTA = ?"
                    + " AND NUM_AGENCIA = ? AND SENHA = ?");
            pst.setString(1, c.getNumeroConta());
            pst.setString(2, c.getNumeroAgencia());
            pst.setString(3, c.getSenha());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                  contaBanco = rs.getString("NUMERO_CONTA");
                  agenciaBanco = rs.getString("NUM_AGENCIA");
                  novoSaldo = rs.getDouble("SALDO"); 
                  senhaBanco = rs.getString("SENHA");
            }

            if(!contaBanco.equalsIgnoreCase(c.getNumeroConta()) || !agenciaBanco.equalsIgnoreCase(c.getNumeroAgencia())){
                JOptionPane.showMessageDialog(null,"Dados para transferência inválidos!" , "Erro", 0); 
                return;
            } 
            else if(!senhaBanco.equalsIgnoreCase(c.getSenha())){
                JOptionPane.showMessageDialog(null,"Senha inválida!" , "Erro", 0);
                return;
            }
            else if(novoSaldo <= 0){
                JOptionPane.showMessageDialog(null,"Saldo insuficiente!" , "Erro", 0);
                return;
            }
            else{
                novoSaldo -= c.getTransferencia();
            }         

            pst = cs.getConexao().prepareStatement("UPDATE CONTA SET SALDO =" + novoSaldo + "WHERE NUMERO_CONTA = ? AND NUM_AGENCIA = ? AND SENHA = ?");         
            pst.setString(1, c.getNumeroConta());
            pst.setString(2, c.getNumeroAgencia());
            pst.setString(3, c.getSenha());
            pst.executeUpdate();
            pst.close();
            cs.confirmarTransacao();  
            
        //realiza depósito da transferência
        double novoSaldoDeposito = 0;
        String contaDepositoBanco = "", agenciaDepositoBanco = "";
        pst = cs.getConexao().prepareStatement("SELECT NUMERO_CONTA, NUM_AGENCIA, SALDO FROM CONTA WHERE NUMERO_CONTA = ? AND NUM_AGENCIA = ?");
        pst.setString(1, c.getContaDestino());
        pst.setString(2, c.getAgenciaDestino());
        rs = pst.executeQuery();
        while(rs.next()){
              contaDepositoBanco = rs.getString("NUMERO_CONTA");
              agenciaDepositoBanco = rs.getString("NUM_AGENCIA");
              novoSaldoDeposito = rs.getDouble("SALDO");               
        } 
            boolean parar = true;
        if(contaDepositoBanco.equalsIgnoreCase(c.getNumeroConta()) && agenciaDepositoBanco.equalsIgnoreCase(c.getNumeroAgencia())){ 
            JOptionPane.showMessageDialog(null, "Operação inválida!", "Erro", 0); 
            parar = false;
            return;
        }
        else if(c.getTransferencia() <= 0 && parar){
            JOptionPane.showMessageDialog(null, "Valor para transferência deve ser maior que zero.", "Erro", 0); 
            return;            
        }
        else{            
            novoSaldoDeposito +=  c.getTransferencia();           
            JOptionPane.showMessageDialog(null, "Transferência concluída com sucesso!", "Mensagem", 1);
        }
        
        pst = cs.getConexao().prepareStatement("UPDATE CONTA SET SALDO =" + novoSaldoDeposito + "WHERE NUMERO_CONTA = ? AND NUM_AGENCIA = ?");         
        pst.setString(1, c.getContaDestino());
        pst.setString(2, c.getAgenciaDestino());        
        pst.executeUpdate();
        pst.close();
        cs.confirmarTransacao();        
    } 
        else{
            JOptionPane.showMessageDialog(null,"Dados para transferência inválidos!" , "Erro", 0); 
            return;
        } 
    }  
    
    public boolean logar(String agencia, String conta, String senha)throws Exception{
        String contaLogin = "", agenciaLogin = "", senhaLogin = "";
        PreparedStatement pst = cs.getConexao().prepareStatement("SELECT NUM_AGENCIA, NUMERO_CONTA, SENHA FROM CONTA WHERE NUM_AGENCIA = ? AND NUMERO_CONTA = ? AND SENHA = ?");
        pst.setString(1, agencia);
        pst.setString(2, conta );
        pst.setString(3, senha);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
              agenciaLogin = rs.getString("NUM_AGENCIA");   
              contaLogin = rs.getString("NUMERO_CONTA");              
              senhaLogin = rs.getString("SENHA");
        } 
        
        if(!agenciaLogin.equalsIgnoreCase(agencia) && !contaLogin.equalsIgnoreCase(conta) &&
                !senhaLogin.equals(senha)){             
            return false;
        }    
        else{                 
            return true;    
        }
    }
    
   
}
        
    


