
package br.com.quadrado;

public class BrComQuadrado {

    
    public static void main(String[] args) {
       Quadrado q1= new Quadrado(2);
       Quadrado q2= new Quadrado(2.2);
       Quadrado q3= new Quadrado(3);
       Quadrado q4= new Quadrado(4);
       q1.calculaPerimetro();
       q1.calcularArea();
       q1.imprime();
       
       q2.calculaPerimetro();
       q2.calcularArea();
       q2.imprime();
       
       q3.calculaPerimetro();
       q3.calcularArea();
       q3.imprime();
       
       q4.calculaPerimetro();
       q4.calcularArea();
       q4.imprime();
    
    }
}
