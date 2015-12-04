/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import static Principal.Comando.*;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author gusta
 */
public class Principal {

    public Principal() {
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String com;
        Mapa01 m = new Mapa01();
        m.setJogador(Jogador.getInstance("Pedro"));
        System.out.println(m.toString());
        com = sc.next();
        while(!com.equals("end")){
            if (com.equals("w")){
                m.mover(CIMA);
            }
            if (com.equals("a")){
                m.mover(ESQUERDA);
            }
            if (com.equals("s")){
                m.mover(BAIXO);
            }
            if (com.equals("d")){
                m.mover(DIREITA);
            }
            System.out.println(m.toString());
            com = sc.next();
            
        }
    }
}
