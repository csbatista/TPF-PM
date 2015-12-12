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

public class Mapa04 extends Mapa {
      
    public Mapa04() {
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
        setBloco(0, 2, 5);
        setBloco(1, 7, 5);
        setBloco(2, 5, 5);
        setBloco(3, 2, 5);
        setBloco(4, 3, 5);
        setBloco(7, 4, 5);
        setBloco(4, 0, 5);
        setBloco(5, 6, 5);
        setBloco(7, 0, 5);
        setBloco(5, 4, 1);
        setBloco(4, 7, 1);
        setBloco(0, 6, 1);
        setBloco(1, 0, 1);
        setBloco(1, 4, 1);
        setBloco(2, 2, 1);
        setBloco(3, 5, 1);
        setBloco(5, 1, 1);
        setBloco(7, 3, 1);
        setBloco(7, 6, 1);
    }
}
