package br.com.formasGeometricas;

import java.util.ArrayList;

public class ColecaoFormas {

    ArrayList<FormaGeometrica> formas = new ArrayList();

    public void adicionarForma(FormaGeometrica formaGeometrica){
        formas.add(formaGeometrica);
    }
    public void imprimeNomeLista(){
        for (FormaGeometrica formaGeometrica : formas) {

            System.out.println("|   "+formaGeometrica.nome);
        }
    }
    public double calcularAreaTotal(){
        double areaTotal=0;
        for (FormaGeometrica formaGeometrica : formas){
           areaTotal=areaTotal+ formaGeometrica.calculaArea();
        }
        return Math.round(areaTotal);
    }
}
