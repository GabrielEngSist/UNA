
package br.com.televisor;


public class Televisor {
    
    boolean ligado;
    int canal;
    int volume;
    int numeroCanais;
    int volumeMaximo;

    public Televisor(boolean ligado, int canal, int volume,int volumeMaximo,int numeroCanais) {
        this.ligado = ligado;
        this.volumeMaximo=volumeMaximo;
        this.numeroCanais=numeroCanais>0?numeroCanais:1;
        this.volume = volume;
        this.canal = canal%numeroCanais;
        
    }
    public void canalAcima(){
        canal++;
        if(canal > numeroCanais){
            canal = 1;
        }
        
        System.out.println("Mudando canal acima :"+canal);
    }
    public void canalAbaixo(){
        canal--;
        if (canal<1){
            canal = numeroCanais;
        }
        System.out.println("Mudando canal abaixo :"+canal);
    }
    public void volumeAcima(){
        if (volume==volumeMaximo) {
           volume--;
        }
         volume++;
         
        System.out.println("Aumentando Volume :"+volume);
         
    }
    public void volumeAbaixo(){
        if (volume==0) {
            volume++;
        }
        volume--;
        System.out.println("Abaixando Volume :"+volume);
    }
    public void alteraEstado(){
      this.ligado=!this.ligado;
    }
    public void imprimir(){
        System.out.println("________________________________________________");
        System.out.println("Estado em que o televisor se encontra :"+ligado);
        System.out.println("Canal atual:"+canal);
        System.out.println("Volume Maximo do Televisor :"+volumeMaximo);
        System.out.println("Quantidade de canais :"+numeroCanais);
        System.out.println("Volume Atual :"+volume);
    }
}
