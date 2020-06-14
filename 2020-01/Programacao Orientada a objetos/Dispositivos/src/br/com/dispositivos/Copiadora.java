package br.com.dispositivos;

public class Copiadora extends Dispositivo {
    String tipoCopia;

    Copiadora(String marca, int numSerie, int tensao, String tipoCopia) {
        super(marca, numSerie, tensao);
        this.tipoCopia = tipoCopia;
    }

    @Override
    public void exibirDadosDispositivo() {
        super.exibirDadosDispositivo();
        System.out.println("Tipo cópia:"+this.tipoCopia+".");
        System.out.println("==========================");
    }
}
