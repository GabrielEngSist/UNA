package br.com.salaDeAula;

public class SalaAprendizAtivo extends Sala {
    int qtdMesasComp;
    int qtdCadeirasPorMesa;
    int qtdPontosLuz;

    public SalaAprendizAtivo(int numero, int capacidade, float largura, float profundidade, boolean dataShow, boolean caixaDeSom, int qtdMesasComp,int qtdCadeirasPorMesa,int qtdPontosLuz) {
        super(numero, capacidade, largura, profundidade, dataShow, caixaDeSom);
        this.qtdCadeirasPorMesa=qtdCadeirasPorMesa;
        this.qtdMesasComp=qtdMesasComp;
        this.qtdPontosLuz=qtdPontosLuz;
    }

    @Override
    public int calcularCapacidade() {
        return this.qtdMesasComp * this.qtdCadeirasPorMesa;
    }
}
