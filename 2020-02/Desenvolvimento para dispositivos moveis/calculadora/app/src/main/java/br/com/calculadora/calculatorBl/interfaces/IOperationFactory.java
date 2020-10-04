package br.com.calculadora.calculatorBl.interfaces;

import br.com.calculadora.calculatorBl.exceptions.InvalidOperationException;

public interface IOperationFactory {
    IOperacao getOperation() throws InvalidOperationException;
}
