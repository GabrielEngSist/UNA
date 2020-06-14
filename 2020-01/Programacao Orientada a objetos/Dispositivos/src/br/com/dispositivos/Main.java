package br.com.dispositivos;

public class Main {
    public static void main(String[] args){
    Computador computador = new Computador(
    "Computador 1",
    "192.168.11.42",
    "4F5F324A78",
    "Ubunto",
    8,
    1000);
        Computador computador2 = new Computador(
                "Computador 2",
                "192.168.11.37",
                "45679ABC12",
                "Windows 10",
                6,
                500);
    computador.exibirDadosDispositivo();
    computador2.exibirDadosDispositivo();

    Impressora impressora = new Impressora(
            "HP",
            12345678,
            127,
            "1080x720",
            "Colorido",
            "Colorida"
    );

    Multifuncional multifuncional = new Multifuncional(
            "Xerox",
            654322,
            127,
            "1080x720",
            "1080x720",
            "Preto",
            "Escala de cinza",
            "Frente e verso"
            );

    Copiadora copiadora = new Copiadora(
            "Epson",
            43634,
            127,
            "Frente e verso"
    );

    Scanner scanner = new Scanner(
      "Epson",
      6543212,
      127,
      "1080x720"
    );

    Associacao associacao = new Associacao(
            computador
    );

    associacao.adicionarDispositivo(impressora);
    associacao.adicionarDispositivo(scanner);
    associacao.adicionarDispositivo(multifuncional);

    Associacao associacao2 = new Associacao(
            computador2
    );

    associacao2.adicionarDispositivo(multifuncional);
    associacao2.adicionarDispositivo(copiadora);

    Rede rede = new Rede();
    rede.adicionarAssociacao(associacao);
    rede.adicionarAssociacao(associacao2);

    rede.listarAssociacoes();
    }
}
