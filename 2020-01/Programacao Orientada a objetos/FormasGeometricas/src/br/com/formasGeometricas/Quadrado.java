package br.com.formasGeometricas;

public class Quadrado extends FormaGeometrica {

    private double lado;

    public Quadrado(String nome,double lado,Cor corBorda,Cor corPreench) {
        this.lado = lado;
        super.nome=nome;
        super.setCorBorda(corBorda);
        super.setCorPreench(corPreench);
    }

    @Override
    public double calculaArea() {
        return lado*lado;
    }

    @Override
    public double calcularPerimetro() {
        return lado*4;
    }
}
