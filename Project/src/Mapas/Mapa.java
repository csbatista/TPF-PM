/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import GUI.Jogo;
import Principal.Comando;
import static Principal.Comando.BAIXO;
import static Principal.Comando.CIMA;
import static Principal.Comando.DIREITA;
import static Principal.Comando.ESQUERDA;
import Principal.EstadoMorto;
import Principal.Jogador;
import Principal.State;

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
    
    
    public void mover(Comando comando, Jogo jogo) {
        if (getEstadoJogador() instanceof EstadoMorto) { //Se morto, revive
            getEstadoJogador().doAction(this);
        } else {
            if (comando == ESQUERDA) {
                if (getPosJogadorX() - 1 >= 0 && getBloco(getPosJogadorX() - 1, getPosJogadorY()) != 1) {
                    setPosJogadorX(getPosJogadorX() - 1);
                }
            }
            if (comando == DIREITA) {
                if (getPosJogadorX() < getLargura() - 1 && getBloco(getPosJogadorX() + 1, getPosJogadorY()) != 1) {
                    setPosJogadorX(getPosJogadorX() + 1);
                }
            }
            if (comando == CIMA) {
                if (getPosJogadorY() - 1 >= 0 && getBloco(getPosJogadorX(), getPosJogadorY() - 1) != 1) {
                    setPosJogadorY(getPosJogadorY() - 1);
                }
            }
            if (comando == BAIXO) {
                if (getPosJogadorY() < getAltura() - 1 && getBloco(getPosJogadorX(), getPosJogadorY() + 1) != 1) {
                    setPosJogadorY(getPosJogadorY() + 1);
                }
            }
        }

        if (!isPosicaoValida()) {//Se posicao inválida, morre
            System.out.println(getPosJogadorX() + " " + getPosJogadorY() + "\n");
            getEstadoJogador().doAction(this);
        }

        if (getPosJogadorX() + 1 == getLargura() && getPosJogadorY() + 1 == getAltura()) {
            System.out.println(Jogador.getNome() + " PASSOU DE FASE!");
            jogo.mudaFase02();
        }
    }
    
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
        return blocos[posJogadorY][posJogadorX] == 0 || blocos[posJogadorY][posJogadorX] == 3 || blocos[posJogadorY][posJogadorX] == 4;
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