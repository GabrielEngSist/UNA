package br.com.calculadora.domain.enums;

public enum Operacoes {
    ADICAO("+"),
    SUBTRACAO("-"),
    MULTIPLICACAO("*"),
    DIVISAO("/");

    public String _valor;

    Operacoes(String valor) {
        this._valor = valor;
    }

    public static Operacoes fromString(String text) {
        for (Operacoes b : Operacoes.values()) {
            if (b._valor.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
