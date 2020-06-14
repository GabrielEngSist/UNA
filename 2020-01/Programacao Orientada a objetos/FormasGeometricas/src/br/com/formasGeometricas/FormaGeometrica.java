package br.com.formasGeometricas;

public abstract class FormaGeometrica {

    public String nome;
    private int x;
    private int y;
    private  Cor corBorda;
    private  Cor corPreench;
    public String getCorBorda(){
        return corBorda.getCor();
    }
    public void setCorBorda(Cor cor){
        this.corBorda=cor;
    }
    public String getCorPreench(){
        return corPreench.getCor();
    }
    public void setCorPreench(Cor cor){
        this.corPreench=cor;
    }
    public abstract double calculaArea();
    public abstract double calcularPerimetro();

}
