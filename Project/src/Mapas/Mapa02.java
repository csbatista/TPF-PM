package Mapas;

import static Mapas.Comando.*;
import GUI.Jogo;
import EstadosJogador.EstadoMorto;
import EstadosJogador.EstadoVivo;

public class Mapa02 extends Mapa {

    public Mapa02() {
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
        setBloco(0, 6, 1);
        setBloco(1, 0, 1);
        setBloco(1, 4, 1);
        setBloco(2, 2, 1);
        setBloco(3, 4, 1);
        setBloco(3, 7, 1);
        setBloco(5, 2, 1);
        setBloco(5, 7, 1);
        setBloco(7, 0, 1);
        setBloco(7, 3, 1);
        setBloco(7, 6, 1);
        setBloco(0, 2, 2);
        setBloco(1, 7, 2);
        setBloco(1, 5, 2);
        setBloco(3, 0, 2);
        setBloco(3, 2, 2);
        setBloco(3, 5, 2);
        setBloco(4, 3, 2);
        setBloco(5, 1, 2);
        setBloco(5, 6, 2);
        setBloco(6, 4, 2);
        setBloco(7, 7, 3);
    }

    @Override
    public void mover(Comando comando, Jogo jogo) {
        if (getEstadoJogador() instanceof EstadoMorto) { //Se morto, revive
            getEstadoJogador().doAction(this);
        } else {
            if (comando == ESQUERDA) {
                if (getPosJogadorX() < getLargura() - 1 && getBloco(getPosJogadorX() + 1, getPosJogadorY()) != 1) {
                    setPosJogadorX(getPosJogadorX() + 1);
                }
            }
            if (comando == DIREITA) {
                if (getPosJogadorX() - 1 >= 0 && getBloco(getPosJogadorX() - 1, getPosJogadorY()) != 1) {
                    setPosJogadorX(getPosJogadorX() - 1);
                }
            }
            if (comando == CIMA) {
                if (getPosJogadorY() < getAltura() - 1 && getBloco(getPosJogadorX(), getPosJogadorY() + 1) != 1) {
                    setPosJogadorY(getPosJogadorY() + 1);
                }
            }
            if (comando == BAIXO) {
                if (getPosJogadorY() - 1 >= 0 && getBloco(getPosJogadorX(), getPosJogadorY() - 1) != 1) {
                    setPosJogadorY(getPosJogadorY() - 1);
                }
            }
        }

        if (!isPosicaoValida()) {//Se posicao inválida, morre
            jogo.showRedPlane();
            getEstadoJogador().doAction(this);
        }

        if (getPosJogadorX() + 1 == getLargura() && getPosJogadorY() + 1 == getAltura()) {
            jogo.mudarFase(true);
        }
    }

}
