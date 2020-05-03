
package br.com.circulo;

public class BrComCirculo {

    public static void main(String[] args) {
        Circulo c1 = new Circulo(2);
        Circulo c2 = new Circulo(3);
        Circulo c3 = new Circulo(4);
        Circulo c4 = new Circulo(5);
        
        c1.calculaArea();
        c1.calculaPerimetro();
        c1.imprime();
        
        c2.calculaArea();
        c2.calculaPerimetro();
        c2.imprime();
        
        c3.calculaArea();
        c3.calculaPerimetro();
        c3.imprime();
        
        c4.calculaArea();
        c4.calculaPerimetro();
        c4.imprime();
        
    }
    
}
