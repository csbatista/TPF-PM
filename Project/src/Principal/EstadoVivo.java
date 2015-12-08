/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author gusta
 */
public class EstadoVivo implements State {

    @Override
    public void doAction(Mapa mapa) {
        System.out.println("Morto!\n");
        mapa.setEstadoJogador(new EstadoMorto());
        mapa.setPosJogadorX(0);
        mapa.setPosJogadorY(0);
    }

}
