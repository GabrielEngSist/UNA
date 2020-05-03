
package br.com.quadrado;

public class Quadrado {
   
    double lado;
    double area;
    double perimetro;

    public Quadrado(double lado) {
        this.lado = lado;
    }
    public double calcularArea(){
        this.area=(this.lado*this.lado);
        return this.area;
    }
    public double calculaPerimetro(){
        this.perimetro=(4*this.lado);
        return this.perimetro;
    }
    public void imprime(){
        System.out.println("Lado :"+lado);
        System.out.println("Perimetro :"+perimetro);
        System.out.println("Area :"+area);
    }
    
}
