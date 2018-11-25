/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SisBanco.dao;

import br.com.SisBanco.accessories.ConexaoSisbanco;
import br.com.SisBanco.beans.Cliente;
import java.sql.*;
import java.util.Vector;

 /*
 *
 * @author Vinicius
 */
public class ClienteDAO {
    private ConexaoSisbanco cs;

    public ClienteDAO() throws Exception{
        cs = new ConexaoSisbanco();
    }
    
    public void cadastrarCliente(Cliente c)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("INSERT INTO CLIENTE (CPF, NOME, ID_AGENCIA) VALUES (?,?,?)", 
                Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, c.getCpf());
        pst.setString(2, c.getNome());
        pst.setString(3, c.getAgencia());         
        pst.executeUpdate();
        cs.confirmarTransacao();
        pst.close();
    }
    
    public void alterarCliente(Cliente c)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("UPDATE CLIENTE SET NOME = ?, ID_AGENCIA = ? WHERE CPF = ?");
        pst.setString(1, c.getNome());
        pst.setString(2, c.getAgencia());
        pst.setString(3, c.getCpf());
        pst.executeUpdate();
        pst.close();
        cs.confirmarTransacao();
    }
    
    public Cliente consultarCliente(String cpf)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("SELECT * FROM CLIENTE WHERE CPF = ?");
        pst.setString(1, cpf);
        ResultSet rs = pst.executeQuery();
        if(!rs.next()) return null;
        return new Cliente(rs.getString("CPF"), rs.getString("NOME"), rs.getString("ID_AGENCIA"));
    }
    
    public void excluirCliente(String cpf)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("DELETE FROM CLIENTE WHERE CPF = ?");
        pst.setString(1, cpf);
        pst.executeUpdate();
        pst.close();
        cs.confirmarTransacao();       
    }    
    
    public Cliente consultarClientesPorAgencia(String agencia)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("SELECT * FROM CLIENTE WHERE ID_AGENCIA = ?");
        pst.setString(1, agencia);
        ResultSet rs = pst.executeQuery();
        if(!rs.next()) return null;
        return new Cliente(rs.getString("CPF"), rs.getString("NOME"));
    }
    
    public ResultSet carregarGrade()throws Exception{
      Statement stm = cs.getConexao().createStatement();
      return stm.executeQuery("SELECT * FROM CLIENTE ORDER BY NOME");
    }

    public Vector<Cliente> carregarCombo()throws Exception{
       Statement stm = cs.getConexao().createStatement();
        ResultSet rs = stm.executeQuery("SELECT CPF FROM CLIENTE ORDER BY CPF");
        Vector<Cliente> v = new Vector<Cliente>();
        while(rs.next())
            v.add(new Cliente(rs.getString("CPF")));
        return v; 
    }
}
