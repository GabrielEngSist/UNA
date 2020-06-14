package br.com.dispositivos;

public abstract class Dispositivo implements InterfaceExibirDadosDispositivo {
    String marca;
    int numSerie;
    int tensao;

    Dispositivo(String marca, int numSerie, int tensao){
        this.marca = marca;
        this.numSerie = numSerie;
        this.tensao = tensao;
    }

    @Override
    public void exibirDadosDispositivo(){
        System.out.println("=========Dados do dispositivo:===========");
        System.out.println("Marca: "+this.marca+".");
        System.out.println("Num. Série.:"+this.numSerie+".");
        System.out.println("Tensão: "+this.tensao+"V.");
    }
}
