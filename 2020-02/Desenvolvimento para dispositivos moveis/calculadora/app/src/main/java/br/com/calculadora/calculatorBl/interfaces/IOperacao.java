package br.com.calculadora.calculatorBl.interfaces;

import br.com.calculadora.calculatorBl.exceptions.AttemptToDivideByZero;

public interface IOperacao {
    public double calcular(double numero1, double numero2) throws AttemptToDivideByZero;
}
