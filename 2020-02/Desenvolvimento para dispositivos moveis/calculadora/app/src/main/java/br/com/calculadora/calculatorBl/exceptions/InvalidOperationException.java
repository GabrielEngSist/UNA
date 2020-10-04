package br.com.calculadora.calculatorBl.exceptions;

public class InvalidOperationException extends Exception {
    public InvalidOperationException(){
        super("Operação inválida");
    }
}
