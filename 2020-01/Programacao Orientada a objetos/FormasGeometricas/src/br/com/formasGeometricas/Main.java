package br.com.formasGeometricas;

public class Main {
    public static void main(String[] args){
        ColecaoFormas c1 = new ColecaoFormas();

        Cor verde= new Cor(0,255,0);
        Cor vermelho= new Cor(255,0,0);
        Cor azul= new Cor (0,0,255);

        Triangulo t1= new Triangulo("Triangulo",2,2,2,2,2,vermelho,azul);
        System.out.println("Area Triangulo " + t1.calculaArea());
        System.out.println("Perimetro Triangulo "+ t1.calcularPerimetro());
        System.out.println("Cor borda :"+t1.getCorBorda());
        System.out.println("Cor Preenchimento : "+t1.getCorPreench());
        System.out.println("________________________________________________");
        Quadrado q1= new Quadrado("Quadrado",2,azul,vermelho);
        System.out.println("Area quadrado " + q1.calculaArea());
        System.out.println("Perimetro quadrado "+ q1.calcularPerimetro());
        System.out.println("Cor borda :"+q1.getCorBorda());
        System.out.println("Cor Preenchimento : "+q1.getCorPreench());
        System.out.println("________________________________________________");
        Circulo cir1= new Circulo ("Circulo",2,verde,verde);
        System.out.println("Area circulo "+cir1.calculaArea());
        System.out.println("Perimetro circulo"+cir1.calcularPerimetro());
        System.out.println("Cor borda :"+cir1.getCorBorda());
        System.out.println("Cor Preenchimento : "+cir1.getCorPreench());
        System.out.println("________________________________________________");
        Retangulo r1= new Retangulo("Retangulo",6,3, vermelho,vermelho);
        System.out.println("Area Retangulo "+ r1.calculaArea());
        System.out.println("Perimetro Retangulo "+ r1.calcularPerimetro());
        System.out.println("Cor borda :"+r1.getCorBorda());
        System.out.println("Cor Preenchimento : "+r1.getCorPreench());
        System.out.println("________________________________________________");
        c1.adicionarForma(t1);
        c1.adicionarForma(q1);
        c1.adicionarForma(cir1);
        c1.adicionarForma(r1);

        System.out.println("--Lista--");
        c1.imprimeNomeLista();
        System.out.println("Area total da Lista :"+c1.calcularAreaTotal());
    }

}
