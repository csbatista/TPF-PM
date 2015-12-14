package Mapas;

import GUI.*;
import Principal.Comando;
import Principal.EstadoVivo;
import Principal.Jogador;

public class Mapa05 extends Mapa {

    public Mapa05() {
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
        setBloco(0, 6, 4);
        setBloco(1, 0, 4);
        setBloco(1, 4, 4);
        setBloco(2, 2, 4);
        setBloco(3, 4, 4);
        setBloco(3, 7, 4);
        setBloco(5, 2, 4);
        setBloco(5, 7, 4);
        setBloco(7, 0, 4);
        setBloco(7, 3, 4);
        setBloco(7, 6, 4);
        setBloco(0, 2, 5);
        setBloco(1, 7, 5);
        setBloco(1, 5, 5);
        setBloco(3, 0, 5);
        setBloco(3, 2, 5);
        setBloco(3, 5, 5);
        setBloco(4, 3, 5);
        setBloco(5, 1, 5);
        setBloco(5, 6, 5);
        setBloco(6, 4, 5);
        setBloco(7, 7, 3);
    }

    @Override
    public void mover(Comando comando, Jogo jogo) {

        super.mover(comando, jogo);
        if (getPosJogadorX() + 1 == getLargura() && getPosJogadorY() + 1 == getAltura()) {
            jogo.removeAll();
            jogo.dispose();
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Fim().setVisible(true);
                }
            });
        }
    }
}
