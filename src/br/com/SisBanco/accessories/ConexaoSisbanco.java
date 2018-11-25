package br.com.SisBanco.accessories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vinic
 */
public class ConexaoSisbanco {
     private static Connection conexao;
    
    /*Construtor verifica se a conexão já foi aberta. Caso contrário promove a conexão*/
    public ConexaoSisbanco()throws Exception{
        try{
            if(conexao != null && !conexao.isClosed()) return; //Se já tiver aberta retorna
            Class.forName("com.mysql.jdbc.Driver"); //Se não estiver aberta tenta carregar e registrar o driver JDBC
            //Abre uma nova conexão com o método getConnection
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3310/sisbanco?useSSL=false","root","root");
            conexao.setAutoCommit(false); //Desabilita o método de autoconfirmação da conexão
            conexao.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE); //Define o nível de isolamento das transações
        }
        catch(ClassNotFoundException cnf){
            throw new Exception("Driver não encontrado!");
        }
        catch(SQLException sql){
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }
 
    /*
    Método de leitura para o atributo conexão. Permite recuperar uma referência que aponte diretamente
        para o objeto que representa a conexão
    */
    public Connection getConexao(){
        return conexao;
    }
    
    //Método responsável por fechar a conexão
    public void fechar()throws Exception{
        try{
            if(conexao == null || conexao.isClosed()) return;
            conexao.close();
        }
        catch(SQLException sql){
            throw new Exception("Falha ocorrida:" + sql.getMessage());
        }
    }
    
    /*
    Método responsável por confirmar a transação, fazendo assim que as operações realizadas no banco de dados
        se tornem permanentes
    */
    public void confirmarTransacao() throws Exception{
        try{
            if(conexao == null || conexao.isClosed())return;
            conexao.commit();
        }
        catch(SQLException sql){
             throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }
    /*
    Método que desfaz todas as alterações que haviam sido realizadas no banco de dados pelas instruções 
    executadas desde o início da transação
    */
    public void cancelarTrasacao() throws Exception{
        try{
            if(conexao == null || conexao.isClosed())return;
            conexao.rollback();
        }
        catch(SQLException sql){
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }    
}


