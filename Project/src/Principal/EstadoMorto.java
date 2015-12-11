/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Mapas.Mapa;

/**
 *
 * @author gusta
 */
public class EstadoMorto implements State{

    @Override
    public void doAction(Mapa mapa) {
        System.out.println("Revivendo...\n");
        mapa.setEstadoJogador(new EstadoVivo());
    }
    
}
