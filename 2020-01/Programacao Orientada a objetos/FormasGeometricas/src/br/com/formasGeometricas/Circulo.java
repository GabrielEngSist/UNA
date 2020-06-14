package br.com.formasGeometricas;

public class Circulo extends FormaGeometrica {
    private double raio;

    public Circulo(String nome,double raio,Cor corBorda,Cor corPreench) {
        this.raio = raio;
        super.nome=nome;
        super.setCorBorda(corBorda);
        super.setCorPreench(corPreench);
    }

    @Override
    public double calculaArea() {
        return (Math.PI*raio*raio);
    }

    @Override
    public double calcularPerimetro() {
        return (2*Math.PI*raio);
    }
}
