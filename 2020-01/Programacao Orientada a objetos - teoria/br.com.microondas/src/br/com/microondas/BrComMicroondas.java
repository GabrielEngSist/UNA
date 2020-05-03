
package br.com.microondas;

public class BrComMicroondas {

    public static void main(String[] args) {
        
        Microondas m1= new Microondas(true,true);
        m1.alteraFechado();
        m1.ligar();
        m1.imprime();
        
        Microondas m2= new Microondas(true,false);
        m2.alteraFechado();
        m2.ligar();
        m2.imprime();
        
        Microondas m3= new Microondas(false,true);
        m3.ligar();
        m3.imprime();
        
        Microondas m4= new Microondas(true,false);
        m4.desligar();
        m4.imprime();
    }
    
}
