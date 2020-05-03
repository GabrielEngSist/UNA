
package br.com.microondas;

public class Microondas {
    
    boolean ligado;
    boolean fechado;

    public Microondas(boolean ligado, boolean fechado) {
        this.ligado = ligado;
        this.fechado = fechado;
    }
    
    public void ligar(){
        this.ligado = fechado;            
    }
    
    public void desligar(){
        this.ligado = false;
    }
    public void alteraFechado(){
        this.fechado=!this.fechado;
    }
    public void imprime(){
        System.out.println("Microondas Ligado? :"+ligado);
        System.out.println("Microondas Fechado? :"+fechado);
        System.out.println("_______________________________");
    }
}
