package br.com.calculadora.calculatorBl.exceptions;

public class AttemptToDivideByZero extends Exception {
    public AttemptToDivideByZero(double numero1){
        super(String.format("Não é possível dívidir por Zero (%s/0)", numero1));
    }
}
