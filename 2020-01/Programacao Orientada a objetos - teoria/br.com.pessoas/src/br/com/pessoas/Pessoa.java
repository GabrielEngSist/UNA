/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pessoas;

/**
 *
 * @author Vitor Oliveira Silva
 */
public class Pessoa {
    /*1) Escreva um código em Java que apresente a classe Pessoa, com atributos nome,
endereco e telefone e, o método imprimir. O método imprimir deve mostrar na
tela os valores de todos os atributos.*/
    
    String nome;
    String endereco;
    String telefone;

    public Pessoa(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public void imprime(){
        System.out.println("Nome : "+nome);
        System.out.println("Endereço : "+endereco);
        System.out.println("Telefone : "+telefone);
    }
    
    
}
    
    


