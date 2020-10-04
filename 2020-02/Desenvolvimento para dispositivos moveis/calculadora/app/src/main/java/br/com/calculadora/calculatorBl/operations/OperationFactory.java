package br.com.calculadora.calculatorBl.operations;

import br.com.calculadora.calculatorBl.exceptions.InvalidOperationException;
import br.com.calculadora.calculatorBl.interfaces.IOperacao;
import br.com.calculadora.calculatorBl.interfaces.IOperationFactory;
import br.com.calculadora.domain.enums.Operacoes;

public class OperationFactory implements IOperationFactory {
    private final Operacoes _operacao;

    public OperationFactory(Operacoes operacao){
        this._operacao = operacao;
    }
    @Override
    public IOperacao getOperation() throws InvalidOperationException {
        switch (this._operacao){
            case ADICAO:
                return new Adicao();
            case DIVISAO:
                return new Divisao();
            case MULTIPLICACAO:
                return new Multiplicacao();
            case SUBTRACAO:
                return new Subtracao();
            default:
                throw new InvalidOperationException();
        }
    }
}
