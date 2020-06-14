package br.com.salaDeAula;

public class Sala {
    int numero;
    int capacidade;
    float largura;
    float profundidade;
    boolean dataShow;
    boolean caixaDeSom;

    public Sala(int numero, int capacidade, float largura, float profundidade, boolean dataShow, boolean caixaDeSom) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.largura = largura;
        this.profundidade = profundidade;
        this.dataShow = dataShow;
        this.caixaDeSom = caixaDeSom;
    }
    public int calcularCapacidade(){
      return  this.capacidade;
    }

}