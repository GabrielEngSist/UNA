package br.com.calculadora.calculatorBl.operations;

import br.com.calculadora.calculatorBl.exceptions.AttemptToDivideByZero;
import br.com.calculadora.calculatorBl.interfaces.IOperacao;

public class Divisao implements IOperacao {
    @Override
    public double calcular(double numero1, double numero2) throws AttemptToDivideByZero {
        if(numero2 == 0){
            throw new AttemptToDivideByZero(numero1);
        }
        return numero1 / numero2;
    }
}
