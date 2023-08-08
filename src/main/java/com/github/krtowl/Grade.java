package com.github.krtowl;

import java.util.Objects;

public class Grade {
    final private Tamanho linhas;
    final private Tamanho colunas;
    private final boolean[][] gradeMontada;
    private Celula celula;
    public Grade(Tamanho linhas, Tamanho colunas) {
        this.linhas = Objects.requireNonNull(linhas);
        this.colunas = Objects.requireNonNull(colunas);
        this.gradeMontada = new boolean[colunas.getModulo()][linhas.getModulo()];
    }

    public Tamanho getLinhas() {
        return linhas;
    }
    public Tamanho getColunas() {
        return colunas;
    }

    public boolean isViva(int coluna, int linha) {
        return gradeMontada[coluna][linha];
    }

    public void mostrarGradeMontada(){
        celula = new Celula();
        for (int y = 0; y < linhas.getModulo(); y++) {
            for (int x = 0; x < colunas.getModulo(); x++) {
                if (gradeMontada[x][y]) {
                    celula.printVivo();
                } else {
                    celula.printMorto();
                }
            }
            System.out.println(); // Pula para a próxima linha
        }
    }

    public void trocarCelulaParaViva(int coluna, int linha) {
        if (linha >= 0 && linha < linhas.getModulo() && coluna >= 0 && coluna < colunas.getModulo()) {
            gradeMontada[coluna][linha] = true;
        } else {
            System.out.println("Coordenadas inválidas!");
        }
    }

    int contaQuantosVizinhosEstaoVivos(int xCelula, int yCelula) {
        var contador = 0;

        if (isVizinhoNoresteVivo(xCelula, yCelula)) {
            contador += 1;
        }

        if (isVizinhoNorteVivo(xCelula, yCelula)) {
            contador += 1;
        }

        if (isVizinhoNordesteVivo(xCelula, yCelula)) {
            contador += 1;
        }

        if (isVizinhoOesteVivo(xCelula, yCelula)) {
            contador += 1;
        }

        if (isVizinhoLesteVivo(xCelula, yCelula)) {
            contador += 1;
        }

        if (isVizinhoSudoesteVivo(xCelula, yCelula)) {
            contador += 1;
        }

        if (isVizinhoSulVivo(xCelula, yCelula)) {
            contador += 1;
        }

        if (isVizinhoSudesteVivo(xCelula, yCelula)) {
            contador += 1;
        }
        return contador;
    }

    boolean isVizinhoNoresteVivo(int xCelula, int yCelula) {
        var xVizinhoNegativo = xCelula - 1;
        var yVizinhosNegativo = yCelula - 1;
        return xVizinhoNegativo >= 0 && xVizinhoNegativo < gradeMontada.length && yVizinhosNegativo >= 0
                && yVizinhosNegativo < gradeMontada[0].length && gradeMontada[xVizinhoNegativo][yVizinhosNegativo];

    }

    boolean isVizinhoNorteVivo(int xCelula, int yCelula) {
        var xVizinhoNegativo = xCelula - 1;
        return xVizinhoNegativo >= 0 && xVizinhoNegativo < gradeMontada.length && yCelula >= 0 && yCelula < gradeMontada[0].length
                && gradeMontada[xVizinhoNegativo][yCelula];

    }

    boolean isVizinhoNordesteVivo(int xCelula, int yCelula) {
        var xVizinhoNegativo = xCelula - 1;
        var yVizinhoPositivo = yCelula + 1;
        return xVizinhoNegativo >= 0 && xVizinhoNegativo < gradeMontada.length && yVizinhoPositivo >= 0
                && yVizinhoPositivo < gradeMontada[0].length && gradeMontada[xVizinhoNegativo][yVizinhoPositivo];
    }

    boolean isVizinhoOesteVivo(int xCelula, int yCelula) {
        var yVizinhosNegativo = yCelula - 1;
        return xCelula >= 0 && xCelula < gradeMontada.length && yVizinhosNegativo >= 0 && yVizinhosNegativo < gradeMontada[0].length
                && gradeMontada[xCelula][yVizinhosNegativo];
    }

    boolean isVizinhoLesteVivo(int xCelula, int yCelula) {
        var yVizinhoPositivo = yCelula + 1;
        return xCelula >= 0 && xCelula < gradeMontada.length && yVizinhoPositivo >= 0 && yVizinhoPositivo < gradeMontada[0].length
                && gradeMontada[xCelula][yVizinhoPositivo];
    }

    boolean isVizinhoSudoesteVivo(int xCelula, int yCelula) {
        var yVizinhosNegativo = yCelula - 1;
        var xVizinhoPositivo = xCelula + 1;
        return xVizinhoPositivo >= 0 && xVizinhoPositivo < gradeMontada.length && yVizinhosNegativo >= 0
                && yVizinhosNegativo < gradeMontada[0].length && gradeMontada[xVizinhoPositivo][yVizinhosNegativo];
    }

    boolean isVizinhoSulVivo(int xCelula, int yCelula) {
        var xVizinhoPositivo = xCelula + 1;
        return xVizinhoPositivo >= 0 && xVizinhoPositivo < gradeMontada.length && yCelula >= 0 && yCelula < gradeMontada[0].length
                && gradeMontada[xVizinhoPositivo][yCelula];
    }

    boolean isVizinhoSudesteVivo(int xCelula, int yCelula) {
        var xVizinhoPositivo = xCelula + 1;
        var yVizinhoPositivo = yCelula + 1;
        return xVizinhoPositivo >= 0 && xVizinhoPositivo < gradeMontada.length && yVizinhoPositivo >= 0
                && yVizinhoPositivo < gradeMontada[0].length && gradeMontada[xVizinhoPositivo][yVizinhoPositivo];
    }

    boolean regrasGameOfLife(int xCelula, int yCelula) {

        if (gradeMontada[xCelula][yCelula] && contaQuantosVizinhosEstaoVivos(xCelula, yCelula) < 2) {
            return false;
        } else if (gradeMontada[xCelula][yCelula] && contaQuantosVizinhosEstaoVivos(xCelula, yCelula) > 3) {
            return false;
        } else if (!gradeMontada[xCelula][yCelula] && contaQuantosVizinhosEstaoVivos(xCelula, yCelula) == 3) {
            return true;
        } else if (gradeMontada[xCelula][yCelula] && (contaQuantosVizinhosEstaoVivos(xCelula, yCelula) == 2
                || contaQuantosVizinhosEstaoVivos(xCelula, yCelula) == 3)) {
            return true;
        } else
            return false;

    }
    public Grade proximo(){
        var proximaGeracao = new Grade(linhas, colunas);
        for (int y = 0; y < linhas.getModulo(); y++) {
            for (int x = 0; x < colunas.getModulo(); x++) {
                proximaGeracao.gradeMontada[x][y] = regrasGameOfLife(x, y);
            }
        }
        return proximaGeracao;
    }



}
