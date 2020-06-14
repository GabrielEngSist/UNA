package br.com.dispositivos;

import java.util.ArrayList;
import java.util.List;

public class Rede {
    List<Associacao> associacaoList;
    public Rede(){
        this.associacaoList = new ArrayList<>();
    }
    public void listarAssociacoes(){
        for (Associacao associacao:associacaoList) {
            System.out.println("_________________Computador:_________________");
            associacao.computador.exibirDadosDispositivo();
            System.out.println("Dispositivos:");
            for (Dispositivo dispositivo: associacao.dispositivoList
                 ) {
                dispositivo.exibirDadosDispositivo();
            }
            System.out.println("_____________________________________________");
        }
    }

    public void adicionarAssociacao(Associacao associacao){
        this.associacaoList.add(associacao);
    };
}
