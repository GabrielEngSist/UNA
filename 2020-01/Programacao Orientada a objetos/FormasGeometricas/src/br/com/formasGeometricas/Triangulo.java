package br.com.formasGeometricas;

public class Triangulo extends FormaGeometrica {
    private double altura;
    private double base;
    private double ladoA,ladoB,ladoC;

    public Triangulo(String nome,double altura, double base, double ladoA, double ladoB, double ladoC,Cor corBorda,Cor corPreench) {
        this.altura = altura;
        this.base = base;
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
        super.nome=nome;
        super.setCorBorda(corBorda);
        super.setCorPreench(corPreench);
    }

    @Override
    public double calculaArea() {
        return (base*altura)/2;
    }

    @Override
    public double calcularPerimetro() {
        return ladoA+ladoB+ladoC;
    }
}
