package Principal;

import Mapas.Mapa;

public class EstadoVivo implements State {

    @Override
    public void doAction(Mapa mapa) {
        mapa.setEstadoJogador(new EstadoMorto());
        mapa.setPosJogadorX(0);
        mapa.setPosJogadorY(0);
    }

}
