package br.com.dispositivos;

public class Scanner extends Dispositivo {
    String resolucaoDigitalizacao;

    Scanner(String marca, int numSerie, int tensao, String resolucaoDigitalizacao) {
        super(marca, numSerie, tensao);
        this.resolucaoDigitalizacao = resolucaoDigitalizacao;
    }

    @Override
    public void exibirDadosDispositivo() {
        super.exibirDadosDispositivo();
        System.out.println("Resolução digitalização:"+this.resolucaoDigitalizacao+".");
        System.out.println("==========================");
    }
}
