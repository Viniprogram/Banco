/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SisBanco.dao;

import br.com.SisBanco.accessories.ConexaoSisbanco;
import br.com.SisBanco.beans.ContaCorrente;
import java.sql.*;

/**
 *
 * @author Vinicius
 */
public class ContaCorrenteDAO {
    private ConexaoSisbanco cs;

    public ContaCorrenteDAO() throws Exception{
        cs = new ConexaoSisbanco();
    }
    
    public void cadastrarContaCorrente(ContaCorrente cc)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("INSERT INTO CONTA (NUMERO_CONTA, NUM_AGENCIA, ID_CPF, TIPO_CONTA,"
                + " SALDO, CHEQUE_ESPECIAL, SENHA) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, cc.getNumeroConta());
        pst.setString(2, cc.getNumeroAgencia());
        pst.setString(3, cc.getCpf());
        pst.setString(4, cc.getTipoConta());
        pst.setDouble(5, cc.getSaldo());
        pst.setDouble(6, cc.getChequeEspecial());
        pst.setString(7, cc.getSenha());
        pst.executeUpdate();
        cs.confirmarTransacao();
        pst.close();
    }
    
    public void alterarContaCorrente(ContaCorrente cc)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("UPDATE CONTA SET TIPO_CONTA = ?,"
                + " SALDO = ?, CHEQUE_ESPECIAL = ? WHERE NUMERO_CONTA = ?");
        pst.setString(1, cc.getTipoConta());
        pst.setDouble(2, cc.getSaldo());
        pst.setDouble(3,cc.getChequeEspecial());
        pst.setString(4, cc.getNumeroConta());
        pst.executeUpdate();
        pst.close();
        cs.confirmarTransacao();
    }
    
    public ContaCorrente consultarContaCorrente(String numeroConta, String tipoConta)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("SELECT * FROM CONTA WHERE NUMERO_CONTA = ? AND TIPO_CONTA = ?");
        pst.setString(1, numeroConta);
        pst.setString(2, tipoConta);
        ResultSet rs = pst.executeQuery();
        if(!rs.next()) return null;
        return new ContaCorrente(rs.getString("NUM_AGENCIA"), rs.getString("TIPO_CONTA"), rs.getString("ID_CPF"), rs.getString("NUMERO_CONTA"),
                rs.getDouble("SALDO"), rs.getDouble("CHEQUE_ESPECIAL"));
    }
    
    public void excluirContaCorrente(int numeroConta)throws Exception{
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
