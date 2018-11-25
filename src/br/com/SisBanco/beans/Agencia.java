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
public class Agencia {
    private String numero;
    private String nome;
    
    public Agencia(String numero){
        this.numero = numero;
    }
    
    public Agencia(){
        this("","");
    }
    
    public Agencia(String numero, String nome){
        this.numero = numero;
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }    
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.numero);
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
        final Agencia other = (Agencia) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }    
}
