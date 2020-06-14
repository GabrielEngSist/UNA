package br.com.formasGeometricas;

public class Retangulo extends FormaGeometrica {

    private double base;
    private double altura;

    public Retangulo(String nome, double base, double altura,Cor corBorda,Cor corPreench) {

        this.base = base;
        this.altura = altura;
        super.nome=nome;
        super.setCorBorda(corBorda);
        super.setCorPreench(corPreench);

    }

    @Override
    public double calculaArea() {
        return base*altura;
    }

    @Override
    public double calcularPerimetro() {
        return (2*base)+(2*altura);
    }
}
