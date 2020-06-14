package br.com.salaDeAula;

public class Hora {
    int hora;
    int minuto;
    int segundos;

    public Hora(int hora,int minuto, int segundos){
        this.hora=hora >= 24 || hora < 0 ? 0 : hora;
        this.minuto=minuto >= 60 || minuto < 0 ? 0: minuto;
        this.segundos=segundos >= 60 || segundos < 0 ? 0 : segundos;
    }

    public int getTotalSeconds(){
        int totalSegundos =  this.segundos + this.minuto * 60 + this.hora * (int)Math.pow(60,2);
        return totalSegundos;
    }

    public static String getHoraBySeconds(int seconds){
        int hora = seconds/3600;
        int minutos = (seconds - hora * 3600)/60;
        int segundos = seconds - hora * 3600 - minutos * 60;

        Hora h = new Hora(hora, minutos, segundos);
        return h.formataHora();
    }

    public String formataHora(){
        return this.hora + ":" + this.minuto + ":" + this.segundos;
    }


    public static String duracao(Hora inicio, Hora fim){
        int duracao =  Math.abs(fim.getTotalSeconds() - inicio.getTotalSeconds());
        if(fim.getTotalSeconds() < inicio.getTotalSeconds()){
            duracao += 24 * (int)Math.pow(60,2);
        }

        return getHoraBySeconds(duracao);
    }
}