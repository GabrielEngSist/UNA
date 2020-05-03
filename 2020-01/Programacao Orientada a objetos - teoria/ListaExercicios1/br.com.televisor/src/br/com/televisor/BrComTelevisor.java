
package br.com.televisor;

public class BrComTelevisor {

    public static void main(String[] args) {
      Televisor t1 = new Televisor(true, 45,2, 20, 50);
      t1.imprimir();
      t1.volumeAcima();
      t1.volumeAbaixo();
      t1.volumeAbaixo();
      t1.volumeAbaixo();
      t1.volumeAbaixo();
      t1.volumeAbaixo();
      
      Televisor t2 = new Televisor(false,45,2,20,50);
      t2.imprimir();
      t2.canalAcima();
      t2.canalAcima();
      t2.canalAcima();
      t2.canalAcima();
      t2.canalAcima();
      t2.canalAcima();
      t2.canalAcima();
      
      Televisor t3 = new Televisor(false,45,2,20,50);
      t3.imprimir();
      t3.canalAbaixo();
      t3.canalAbaixo();
      t3.canalAbaixo();
      t3.canalAbaixo();
      t3.canalAbaixo();
      t3.canalAbaixo();
      
      Televisor t4 = new Televisor(false,45,2,20,50);
      t4.alteraEstado();
      t4.imprimir();
      
    }
    
}
