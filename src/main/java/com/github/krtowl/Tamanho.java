package com.github.krtowl;

public class Tamanho {
    private final int modulo;

    public Tamanho(int modulo) throws TamanhoInvalido {
        if(modulo < 1) throw new TamanhoInvalido();
        this.modulo = modulo;
    }

    public int getModulo() {
        return modulo;
    }

    class TamanhoInvalido extends Exception {}
}
