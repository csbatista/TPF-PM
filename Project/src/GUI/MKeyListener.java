/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Principal.Comando.*;
import Principal.Mapa;

/**
 *
 * @author Amanda
 */
public class MKeyListener implements KeyListener {
    Mapa mapinha;
    Jogo joguinho;
    public MKeyListener(Mapa m, Jogo j){
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
            mapinha.mover(CIMA);
            System.out.println("apertou cima");
            joguinho.atualizaGUI();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            mapinha.mover(BAIXO);
            System.out.println("apertou baixo");
            joguinho.atualizaGUI();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mapinha.mover(DIREITA);
            System.out.println("apertou dir");
            joguinho.atualizaGUI();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mapinha.mover(ESQUERDA);
            System.out.println("apertou esq");
            joguinho.atualizaGUI();
        }
        System.out.println(mapinha.toString());
    }

}
