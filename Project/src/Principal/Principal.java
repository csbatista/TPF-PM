/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import static Principal.Comando.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import GUI.MKeyListener;

/**
 *
 * @author gusta
 */
public class Principal {

    public Principal() {
    }
    
    public static void main(String[] args) throws IOException {
        GUI.Jogo b = new GUI.Jogo();
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //b.setLocation(dim.width/2-b.getSize().width/2, dim.height/2-b.getSize().height/2);
        b.setVisible(true);
        
        Scanner sc = new Scanner(System.in);
        String com;
        //Mapa01 m = new Mapa01();
        //m.setJogador(Jogador.getInstance("Pedro"));
        //System.out.println(m.toString());
        //b.addKeyListener(new MKeyListener(m));
       
        while(true){
            
//            if (com.equals("w")){
//                m.mover(CIMA);   
//            }
//            if (com.equals("a")){
//                m.mover(ESQUERDA);
//            }
//            if (com.equals("s")){
//                m.mover(BAIXO);
//            }
//            if (com.equals("d")){
//                m.mover(DIREITA);
//            }
            //System.out.println(m.toString());            
        }
    }
}