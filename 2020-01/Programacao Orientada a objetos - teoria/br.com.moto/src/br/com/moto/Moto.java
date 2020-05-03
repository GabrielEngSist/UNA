package br.com.moto;

public class Moto {
    
    String marca, modelo, cor;
    int marcha = 0;
    int menorMarcha,maiorMarcha;
    boolean estado=false;
    public Moto(String marca, String modelo, String cor, int marcha,int menorMarcha,int maiorMarcha,boolean ligar){
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        validaMarcha(marcha,menorMarcha,maiorMarcha);
        this.marcha=marcha;
        this.maiorMarcha=maiorMarcha;
        this.menorMarcha=menorMarcha;
        this.estado=ligar;
    }
    public void alteraEstado(){
        estado=!estado;
    }
    private void validaMarcha(int marchaAtual,int menorMarcha,int maiorMarcha){
        if (menorMarcha<0) {
            this.menorMarcha=0;
        }
        if (menorMarcha>=maiorMarcha) {
            throw new IllegalArgumentException("Marcha invalida");
        }
        if (marchaAtual<menorMarcha || marchaAtual> maiorMarcha){
            throw new IllegalArgumentException("Marcha atual invalida");
        }
    }
    public void marchaAcima(){
        if (marcha >=menorMarcha && marcha<maiorMarcha) {
           marcha++;     
            
        }   
        sequencia();
    }
        
    public void marchaAbaixo(){
        if(marcha>menorMarcha && marcha<=maiorMarcha){
            marcha--;
        }

        sequencia();
    }
    
    public void imprime() {
        System.out.println("Marca :"+marca);
        System.out.println("Modelo :"+modelo);
        System.out.println("Cor :"+cor);
        System.out.println("Marcha que se encontra:"+marcha);
        System.out.println("Maior marcha :"+maiorMarcha);
        System.out.println("Menor marcha :"+menorMarcha);
        sequencia();
        System.out.println(estado?"ligado":"desligado");
        System.out.println("__________________________________");
  
    }
public void sequencia(){
        String marchas = "";
        for (int i = menorMarcha; i <= maiorMarcha; i++) {
            String marchaString = i == marcha ? "["+i+"]": ""+i;
            marchas += " "+marchaString+" ";
        }
        
        System.out.println(marchas);
}
}
