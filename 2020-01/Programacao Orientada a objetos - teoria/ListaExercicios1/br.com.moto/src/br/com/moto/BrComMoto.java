
package br.com.moto;

public class BrComMoto {

    public static void main(String[] args) {
        Moto m1 = new Moto("Honda","Twister","vermlha",4,2,30,true);
        Moto m2 = new Moto("Honda","BIZ","Preta",1,0,6,false);
        Moto m3 = new Moto("Honda","XRE 190","Azul",2,0,6,true);
        Moto m4 = new Moto("Honda","XRE 300","Amarela",6,0,6,false);
        
       
        m1.marchaAcima();
        m1.marchaAcima();
        m1.marchaAcima();
        m1.marchaAcima();
        m1.marchaAcima();
        m1.marchaAcima();
        m1.marchaAcima();
        m1.marchaAcima();
        m1.marchaAcima();
        
        m1.marchaAbaixo();
        m1.marchaAbaixo();
        m1.marchaAbaixo();
        m1.marchaAbaixo();
        m1.marchaAbaixo();
        m1.marchaAbaixo();
        m1.marchaAbaixo(); 
        m1.marchaAbaixo();
        m1.marchaAbaixo();
              
        m1.imprime();
        m2.imprime();
        m3.imprime();
        m4.imprime();
    }
    
}
