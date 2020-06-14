package br.com.dispositivos;

public class Computador implements InterfaceExibirDadosDispositivo {
    private String apelido;
    private String ip;
    private String mac;
    private String so;
    private int capMemRam;
    private int capHd;

    public Computador(String apelido,
                      String ip,
                      String mac,
                      String so,
                      int capMemRam,
                      int capHd
    ){
        this.apelido = apelido;
        this.ip = ip;
        this.mac = mac;
        this.so = so;
        this.capMemRam = capMemRam;
        this.capHd = capHd;
    }

    public void exibirDadosDispositivo(){
        System.out.println(
                String.format("========== Dados do dispositivo:========== \nApelido: %1$s.\nIP:%2$s.\nMAC:%3$s.\nS.O.:%4$s.\nMem. RAM.:%5$d.\nCap. HD:%6$d.\n======================================== \n",
                        this.apelido,
                        this.ip,
                        this.mac,
                        this.so,
                        this.capMemRam,
                        this.capHd)
        );
    }
}
