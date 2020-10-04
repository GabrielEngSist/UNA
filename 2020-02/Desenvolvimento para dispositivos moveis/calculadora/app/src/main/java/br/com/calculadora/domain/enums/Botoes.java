package br.com.calculadora.domain.enums;

public enum Botoes {
    IGUAL("="), CE("CE"), NUMERICO("1234567890");

    private final String _valor;

    Botoes(String valor){
        this._valor = valor;
    }

    public static Botoes fromString(String text) {
        for (Botoes b : Botoes.values()) {
            if (text.contains(b._valor)) {
                return b;
            }
        }
        return null;
    }
}
