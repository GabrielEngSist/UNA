
package br.com.retangulo;

public class BrComRetangulo {

    
    public static void main(String[] args) {
       Retangulo r1=new Retangulo(3,2);
       Retangulo r2=new Retangulo(4,2);
       Retangulo r3=new Retangulo(5,2);
       Retangulo r4=new Retangulo(6,2);
       
       r1.calculaPerimetro();
       r1.calcularArea();
       r1.imprime();
       
       r2.calculaPerimetro();
       r2.calcularArea();
       r2.imprime();
       
       r3.calculaPerimetro();
       r3.calcularArea();
       r3.imprime();
       
       r4.calculaPerimetro();
       r4.calcularArea();
       r4.imprime();
    }
    
}
