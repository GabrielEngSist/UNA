package br.com.salaDeAula;

public class Laboratorio extends Sala {
    int qtdComputadores;
    int qtdAlunosPorComputadores;
    float velocidadeCPU;
    int tamMemoriaRam;
    int capacidadeHD;
    String sistemaOperacional;

    public Laboratorio(int numero, float largura, float profundidade, boolean dataShow, boolean caixaDeSom,int qtdComputadores, int qtdAlunosPorComputadores, float velocidadeCPU, int tamMemoriaRam, int capacidadeHD, String sistemaOperacional) {
        super(numero, 0, largura, profundidade, dataShow, caixaDeSom);
        this.capacidadeHD=capacidadeHD;
        this.qtdAlunosPorComputadores=qtdAlunosPorComputadores;
        this.qtdComputadores=qtdComputadores;
        this.sistemaOperacional=sistemaOperacional;
        this.tamMemoriaRam=tamMemoriaRam;
        this.velocidadeCPU=velocidadeCPU;
    }

    @Override
    public int calcularCapacidade() {
        return this.qtdAlunosPorComputadores * this.qtdComputadores;
    }
}
