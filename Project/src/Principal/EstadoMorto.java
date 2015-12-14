package Principal;

import Mapas.Mapa;

public class EstadoMorto implements State {

    @Override
    public void doAction(Mapa mapa) {
        mapa.setEstadoJogador(new EstadoVivo());
    }

}
