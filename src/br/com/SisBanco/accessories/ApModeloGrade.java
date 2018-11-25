/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SisBanco.accessories;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vinic
 */
public class ApModeloGrade extends AbstractTableModel{
    private List<String> colunas;
    private List<List<Object>> linhas;
    
    //Construtor cria uma instância dessa classe que represente um modelo de dados vazio
    public ApModeloGrade(){
        colunas = new ArrayList<String>();
        linhas = new ArrayList<List<Object>>();
    }
    
    /*
    Construtor cria uma instância dessa classe que represente um modelo de dados que tenha todas as
    colunas definidas, mas sem nenhuma linha    
    */
    public ApModeloGrade(String[] titulos){
        colunas = new ArrayList<String>();
        for(int i = 0; i < titulos.length; i++)
            colunas.add(titulos[i]);
        linhas = new ArrayList<List<Object>>();
    }
    
    /*Construtor permite criar um modelo de dados já populado, com os títutlos das colunas e com um
        conjunto de linhas*/
    public ApModeloGrade (ResultSet rs, String[] titulos){
        this();
        
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            
            if(titulos != null)
                for(int i = 0; i < titulos.length; i++)
                    colunas.add(titulos[i]);
            else
                for(int i = 0; i <= rsmd.getColumnCount(); i++)
                    colunas.add(rsmd.getColumnLabel(i));
            
            while(rs.next()){
               ArrayList<Object> linha = new ArrayList<Object>();
               for(int i = 1; i <= rsmd.getColumnCount(); i++)
                   linha.add(rs.getObject(i));
               linhas.add(linha);
            }
        } catch (SQLException e) {
       }
    }
    
    //Método retorna uma referência para o atributo que representa as linhas
    public List<List<Object>> getLinhas(){
        return linhas;
    }
    
    //Método retorna o número de colunas existentes
    public int getColumnCount(){
        return colunas.size();
    }
    
    //Método retorna o número de linhas existentes
    public int getRowCount(){
        return linhas.size();
    }
    
    //Método retorna o dado da linha e da coluna especificada
    public Object getValueAt(int linha, int coluna){
        return linhas.get(linha).get(coluna);
    }
    
    //Método retorna o título de qualquer coluna
    public String getColumnName(int indice){
        return colunas.get(indice);
    }
    
    //Método retorna a condição que impede que a célula seja editada
    public boolean isCellEditable(int linha, int coluna){
        return false;
    }
    
    //Método retorna a classe dos objetos gravados na coluna
    public Class getColumnClass(int coluna){
        return getValueAt(0,coluna).getClass();
    }
    
    //Procedimento exclui a linha especificada
    public void removeRow(int linha){
        linhas.remove(linha);
    }
    
    //Procedimento inclui uma nova linha
    public void insertRow(List<Object> linha){
        linhas.add(linha);
    }
    
    //Procedimento exclui todas as linhas do modelo de dados
    public void clearLines(){
        linhas.clear();
    }
}
