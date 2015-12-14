package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Principal.Comando.*;
import Mapas.Mapa;

public class MKeyListener implements KeyListener {

    private final Mapa mapa;
    private final Jogo jogo;

    public MKeyListener(Mapa m, Jogo j) {
        mapa = m;
        jogo = j;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                mapa.mover(CIMA, jogo);
                jogo.atualizaGUI();
                break;
            case KeyEvent.VK_DOWN:
                mapa.mover(BAIXO, jogo);
                jogo.atualizaGUI();
                break;
            case KeyEvent.VK_RIGHT:
                mapa.mover(DIREITA, jogo);
                jogo.atualizaGUI();
                break;
            case KeyEvent.VK_LEFT:
                mapa.mover(ESQUERDA, jogo);
                jogo.atualizaGUI();
                break;
            default:
                break;
        }
        
    }

}
