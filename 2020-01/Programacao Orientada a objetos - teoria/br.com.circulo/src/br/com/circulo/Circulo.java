
package br.com.circulo;

public class Circulo {
   
    double raio;
    double area;
    double perimetro;

    public Circulo(double raio) {
        this.raio = raio;
    }
    
    public double calculaArea(){
        area=(Math.PI*raio*raio);
        return area;
    }
    public double calculaPerimetro(){
        perimetro=(2*Math.PI*raio);
        return perimetro;
    }
    public void imprime(){
        System.out.println("Raio :"+raio);
        System.out.println("Area :"+area);
        System.out.println("Perimetro :"+perimetro);
        System.out.println("______________________________");
    }
}
