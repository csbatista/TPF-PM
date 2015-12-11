/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapas;

import GUI.*;
import Principal.Comando;
import Principal.EstadoMorto;
import Principal.EstadoVivo;
import Principal.Jogador;
import static Principal.Comando.*;

/*
0 0 0 1 0 0 0 0
0 2 0 0 0 2 0 0
0 0 0 1 0 0 0 0
0 2 0 0 0 2 0 0
0 0 0 1 0 0 0 0
0 2 0 0 0 2 0 0
0 0 0 1 0 0 0 0
0 2 0 0 0 2 0 0
 */

public class Mapa03 extends Mapa {
      
    public Mapa03() {
        super(8, 8);
        setBlocos();
        setEstadoJogador(new EstadoVivo());
    }

    @Override
    public void setBlocos() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                setBloco(i, j, 0);
            }
        }
        setBloco(7, 7, 3);
        setBloco(0, 2, 2);
        setBloco(1, 7, 2);
        setBloco(2, 5, 2);
        setBloco(3, 2, 2);
        setBloco(4, 3, 2);
        setBloco(7, 4, 2);
        setBloco(4, 0, 2);
        setBloco(5, 6, 2);
        setBloco(7, 0, 2);
        setBloco(5, 4, 4);
        setBloco(4, 7, 4);
        setBloco(0, 6, 4);
        setBloco(1, 0, 4);
        setBloco(1, 4, 4);
        setBloco(2, 2, 4);
        setBloco(3, 5, 4);
        setBloco(5, 1, 4);
        setBloco(7, 3, 4);
        setBloco(7, 6, 4);
    }

    @Override
    public void mover(Comando comando, Jogo jogo) {
        if (getEstadoJogador() instanceof EstadoMorto) { //Se morto, revive
            getEstadoJogador().doAction(this);
        } else {
            if (comando == ESQUERDA) {
                if (getPosJogadorX() - 1 >= 0 && getBloco(getPosJogadorX() - 1, getPosJogadorY()) != 4) {
                    setPosJogadorX(getPosJogadorX() - 1);
                }
            }
            if (comando == DIREITA) {
                if (getPosJogadorX() < getLargura() - 1 && getBloco(getPosJogadorX() + 1, getPosJogadorY()) != 4) {
                    setPosJogadorX(getPosJogadorX() + 1);
                }
            }
            if (comando == CIMA) {
                if (getPosJogadorY() - 1 >= 0 && getBloco(getPosJogadorX(), getPosJogadorY() - 1) != 4) {
                    setPosJogadorY(getPosJogadorY() - 1);
                }
            }
            if (comando == BAIXO) {
                if (getPosJogadorY() < getAltura() - 1 && getBloco(getPosJogadorX(), getPosJogadorY() + 1) != 4) {
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
            jogo.mudaFase04();
        }
    }

}
