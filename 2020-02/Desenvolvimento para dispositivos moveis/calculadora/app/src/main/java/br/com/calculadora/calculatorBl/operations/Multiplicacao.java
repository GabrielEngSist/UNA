package br.com.calculadora.calculatorBl.operations;

import br.com.calculadora.calculatorBl.interfaces.IOperacao;

public class Multiplicacao implements IOperacao {
    @Override
    public double calcular(double numero1, double numero2) {
        return numero1 * numero2;
    }
}
