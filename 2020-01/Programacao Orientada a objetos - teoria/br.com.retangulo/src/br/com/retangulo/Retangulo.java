
package br.com.retangulo;

public class Retangulo {
    /*Escreva um código em Java que apresente a classe Retangulo, com atributos
comprimento, largura, area e perimetro e, os métodos calcularArea,
calcularPerimetro e imprimir. Os métodos calcularArea e calcularPerimetro
devem efetuar seus respectivos cálculos e colocar os valores nos atributos area e
perimetro. O método imprimir deve mostrar na tela os valores de todos os
atributos. Salienta-se que a área de um retângulo é obtida pela fórmula
(comprimento * largura) e o perímetro por (2 * comprimento) + (2 * largura).
*/
    double comprimento;
    double largura;
    double area;
    double perimetro;

    public Retangulo(double comprimento, double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    
    public double calcularArea(){
        this.area=(this.comprimento*this.largura);
        return this.area;
    }
    public double calculaPerimetro(){
        this.perimetro=(2*this.comprimento)+(2*this.largura);
        return this.perimetro;
    }
    public void imprime(){
        System.out.println("Comprimento :"+comprimento);
        System.out.println("Largura :"+largura);
        System.out.println("Perimetro :"+perimetro);
        System.out.println("Area :"+area);
        System.out.println("________________________________");
    }
    
}
