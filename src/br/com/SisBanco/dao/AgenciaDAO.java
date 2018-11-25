/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SisBanco.dao;

import br.com.SisBanco.beans.Agencia;
import br.com.SisBanco.accessories.ConexaoSisbanco;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Vinicius
 */
public class AgenciaDAO {
    private ConexaoSisbanco cs;

    public AgenciaDAO() throws Exception{
        cs = new ConexaoSisbanco();
    }
    
    public void cadastrarAgencia(Agencia a)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("INSERT INTO AGENCIA (NUMERO_AGENCIA, NOME) VALUES (?,?)", 
                Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, a.getNumero());
        pst.setString(2, a.getNome());
        pst.executeUpdate();
        cs.confirmarTransacao();
        pst.close();
    }
    
    public void alterarAgencia(Agencia a)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("UPDATE AGENCIA SET NOME = ? WHERE NUMERO_AGENCIA = ?");
        pst.setString(1, a.getNome());
        pst.setString(2, a.getNumero());
        pst.executeUpdate();
        pst.close();
        cs.confirmarTransacao();
    }
 /*   
    public Agencia consultarAgencia(int numero)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("SELECT * FROM AGENCIA WHERE NUMERO_AGENCIA = ?");
        pst.setInt(1, numero);
        ResultSet rs = pst.executeQuery();
        if(!rs.next()) return null;
        return new Agencia(rs.getString("NUMERO_AGENCIA"), rs.getString("NOME"));
    }
   */ 
    public Agencia consultarAgencia(String numero)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("SELECT * FROM AGENCIA WHERE NUMERO_AGENCIA = ?");
        pst.setString(1, numero);
        ResultSet rs = pst.executeQuery();
        if(!rs.next()) return null;
        return new Agencia(rs.getString("NUMERO_AGENCIA"), rs.getString("NOME"));
    }
    
    public void excluirAgencia(String agencia)throws Exception{
        PreparedStatement pst = cs.getConexao().prepareStatement("DELETE FROM AGENCIA WHERE NUMERO_AGENCIA = ?");
        pst.setString(1, agencia);
        pst.executeUpdate();
        pst.close();
        cs.confirmarTransacao();       
    }
    
    public ResultSet carregarGrade()throws Exception{
      Statement stm = cs.getConexao().createStatement();
      return stm.executeQuery("SELECT * FROM AGENCIA ORDER BY NUMERO_AGENCIA");
    }    
    
    public Vector<Agencia> carregarCombo()throws Exception{
       Statement stm = cs.getConexao().createStatement();
        ResultSet rs = stm.executeQuery("SELECT NUMERO_AGENCIA FROM AGENCIA ORDER BY NUMERO_AGENCIA");
        Vector<Agencia> v = new Vector<Agencia>();
        while(rs.next())
            v.add(new Agencia(rs.getString("NUMERO_AGENCIA")));
        return v; 
    }
}
