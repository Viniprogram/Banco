/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SisBanco.beans;

import java.util.Objects;

/**
 *
 * @author Vinicius
 */
public class Cliente {
    private String cpf;
    private String nome;
    private String agencia;    
    
    public Cliente(){
        this("","","");
    }
    
    public Cliente(String cpf, String nome, String agencia, String senha){
        this.cpf = cpf;
        this.nome = nome;
        this.agencia = agencia;        
    }
    
    public Cliente(String cpf){
        this.cpf = cpf;
    }
    
    public Cliente(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }
    
    public Cliente(String cpf, String nome, String agencia){
        this.cpf = cpf;
        this.nome = nome;
        this.agencia = agencia;
    }

    public String getCpf() {
        return cpf;
    }   

    public String getNome() {
        return nome;
    }

    public String getAgencia() {
        return agencia;
    }    

    public void setCpf(String cpf) {
        cpf = cpf.replaceAll("\\.","").replaceAll("-","");
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }      
    
    @Override
    public String toString() {
        return cpf;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.cpf);
        return hash;
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }
    
    
}
