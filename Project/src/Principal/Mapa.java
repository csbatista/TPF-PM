/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import GUI.Jogo;

public abstract class Mapa {

    private Jogador jogador;
    private int blocos[][];
    private int largura, altura;
    private int posJogadorX, posJogadorY;
    private State estadoJogador;

    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        blocos = new int[altura][largura];
        posJogadorX = 0;
        posJogadorY = 0;
        estadoJogador = null;
        jogador = null;
    }

    public abstract void mover(Comando comando, Jogo jogo);

    public abstract void setBlocos();

    public Jogador getJogador() {
        return jogador;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public int getPosJogadorX() {
        return posJogadorX;
    }

    public int getPosJogadorY() {
        return posJogadorY;
    }

    public State getEstadoJogador() {
        return estadoJogador;
    }

    public void setBloco(int x, int y, int tipo) {
        if (x >= largura || y >= altura) {
            return;
        }
        blocos[y][x] = tipo;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPosJogadorX(int posJogadorX) {
        this.posJogadorX = posJogadorX;
    }

    public void setPosJogadorY(int posJogadorY) {
        this.posJogadorY = posJogadorY;
    }

    public void setEstadoJogador(State estadoJogador) {
        this.estadoJogador = estadoJogador;
    }

    public int getBloco(int x, int y) {
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        return blocos[y][x];
    }

    public boolean isPosicaoValida() {
        return blocos[posJogadorY][posJogadorX] == 0;
    }

    @Override
    public String toString() {
        String retorno = "";

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if (j == posJogadorX && i == posJogadorY) {
                    retorno += "J ";
                } else {
                    retorno += blocos[i][j] + " ";
                }
            }
            retorno += "\n";
        }
        return retorno;
    }

}
