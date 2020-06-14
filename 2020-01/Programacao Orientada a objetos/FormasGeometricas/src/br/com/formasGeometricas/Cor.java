package br.com.formasGeometricas;

public class Cor {
    private int r;
    private int g;
    private int b;

    public Cor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public String getCor() {
        return "r : "+r+ " g : "+g+ " b : "+b;
    }
}
