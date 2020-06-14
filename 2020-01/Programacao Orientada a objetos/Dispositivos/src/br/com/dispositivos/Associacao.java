package br.com.dispositivos;

import java.util.ArrayList;
import java.util.List;

public class Associacao {
    Computador computador;
    List<Dispositivo> dispositivoList;

    public Associacao(Computador computador){
        this.computador = computador;
        this.dispositivoList = new ArrayList<>();
    }

    public void adicionarDispositivo(Dispositivo dispositivo){
        this.dispositivoList.add(dispositivo);
    }
}
