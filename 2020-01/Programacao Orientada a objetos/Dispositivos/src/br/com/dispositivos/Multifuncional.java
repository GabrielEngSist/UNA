package br.com.dispositivos;

public class Multifuncional extends Dispositivo {

    String resolucaoImpressao;
    String resolucaoDigitalizacao;
    String tipoCartucho;
    String tipoImpressao;
    String tipoCopia;

    public Multifuncional(String marca,
                          int numSerie,
                          int tensao,
                          String resolucaoImpressao,
                          String resolucaoDigitalizacao,
                          String tipoCartucho,
                          String tipoImpressao,
                          String tipoCopia){
        super(marca, numSerie, tensao);
        this.resolucaoImpressao = resolucaoImpressao;
        this.resolucaoDigitalizacao = resolucaoDigitalizacao;
        this.tipoCartucho = tipoCartucho;
        this.tipoImpressao = tipoImpressao;
        this.tipoCopia = tipoCopia;
    }

    @Override
    public void exibirDadosDispositivo() {
        super.exibirDadosDispositivo();
        System.out.println("Resolução impressao:"+this.resolucaoImpressao+".");
        System.out.println("Resolução digitalização:"+this.resolucaoDigitalizacao+".");
        System.out.println("Tipo cartucho:"+this.tipoCartucho+".");
        System.out.println("Tipo impressão:"+this.tipoImpressao+".");
        System.out.println("Tipo cópia:"+this.tipoCopia+".");
        System.out.println("==========================");
    }
}
