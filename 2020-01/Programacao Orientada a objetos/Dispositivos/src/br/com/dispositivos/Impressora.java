package br.com.dispositivos;

public class Impressora extends Dispositivo {

    String tipoImpressao;
    String resolucaoImpressao;
    String tipoCartucho;

    Impressora(String marca, int numSerie, int tensao, String resolucaoImpressao, String tipoCartucho, String tipoImpressao) {
        super(marca, numSerie, tensao);
        this.resolucaoImpressao = resolucaoImpressao;
        this.tipoCartucho = tipoCartucho;
        this.tipoImpressao = tipoImpressao;
    }

    @Override
    public void exibirDadosDispositivo() {
        super.exibirDadosDispositivo();
        System.out.println("Resolução impressao:"+this.resolucaoImpressao+".");
        System.out.println("Tipo cartucho:"+this.tipoCartucho+".");
        System.out.println("Tipo impressão:"+this.tipoImpressao+".");
        System.out.println("==========================");
    }
}
