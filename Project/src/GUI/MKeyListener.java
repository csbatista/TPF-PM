/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Principal.Comando.*;
import Mapas.Mapa;

/**
 *
 * @author Amanda
 */
public class MKeyListener implements KeyListener {

    Mapa mapinha;
    Jogo joguinho;

    public MKeyListener(Mapa m, Jogo j) {
        mapinha = m;
        joguinho = j;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            mapinha.mover(CIMA, joguinho);
            joguinho.atualizaGUI();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            mapinha.mover(BAIXO, joguinho);
            joguinho.atualizaGUI();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mapinha.mover(DIREITA, joguinho);
            joguinho.atualizaGUI();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mapinha.mover(ESQUERDA, joguinho);
            joguinho.atualizaGUI();
        }
        System.out.println(mapinha.toString());
    }

}
