/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SisBanco.dao;

import br.com.SisBanco.accessories.ConexaoSisbanco;
import br.com.SisBanco.beans.ContaPoupanca;
import java.sql.*;

/**
 *
 * @author Vinicius
 */
public class ContaPoupancaDAO {
    private ConexaoSisbanco cs;

    public ContaPoupancaDAO() throws Exception{
        cs = new ConexaoSisbanco();
    }
    
    public void cadastrarContaPoupanca(ContaPoupanca cp)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("INSERT INTO CONTA (NUMERO_CONTA, NUM_AGENCIA, ID_CPF, TIPO_CONTA,"
                + " SALDO, VARIACAO, SENHA) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, cp.getNumeroConta());
        pst.setString(2, cp.getNumeroAgencia());
        pst.setString(3, cp.getCpf());
        pst.setString(4, cp.getTipoConta());
        pst.setDouble(5, cp.getSaldo());
        pst.setFloat(6, cp.getVariacao());
        pst.setString(7, cp.getSenha());
        pst.executeUpdate();
        cs.confirmarTransacao();
        pst.close();
    }
    
    public void alterarContaPoupanca(ContaPoupanca cp)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("UPDATE CONTA SET TIPO_CONTA = ?,"
                + " SALDO = ?, VARIACAO = ? WHERE NUMERO_CONTA = ?");
        pst.setString(1, cp.getTipoConta());
        pst.setDouble(2, cp.getSaldo());
        pst.setFloat(3,cp.getVariacao());
        pst.setString(4, cp.getNumeroConta());
        pst.executeUpdate();
        pst.close();
        cs.confirmarTransacao();
    }
    
    public ContaPoupanca consultarContaPoupanca(String numeroConta, String tipoConta)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("SELECT * FROM CONTA WHERE NUMERO_CONTA = ? AND TIPO_CONTA = ?");
        pst.setString(1, numeroConta);
        pst.setString(2, tipoConta);
        ResultSet rs = pst.executeQuery();
        if(!rs.next()) return null;
        return new ContaPoupanca(rs.getString("NUM_AGENCIA"), rs.getString("TIPO_CONTA"), rs.getString("ID_CPF"), rs.getString("NUMERO_CONTA"),
                rs.getDouble("SALDO"), rs.getFloat("VARIACAO"));
    }
    
    public void excluirContaPoupanca(int numeroConta)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("DELETE FROM CONTA WHERE NUMERO_CONTA = ?");
        pst.setInt(1, numeroConta);
        pst.executeUpdate();
        pst.close();
        cs.confirmarTransacao();       
    }
    
    public ResultSet carregarGrade()throws Exception{
      Statement stm = cs.getConexao().createStatement();
      return stm.executeQuery("SELECT * FROM CONTA ORDER BY TIPO_CONTA");
    }    
}
