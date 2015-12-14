package Mapas;

import GUI.Jogo;
import static Mapas.Comando.BAIXO;
import static Mapas.Comando.CIMA;
import static Mapas.Comando.DIREITA;
import static Mapas.Comando.ESQUERDA;
import EstadosJogador.EstadoMorto;
import Jogador.Jogador;
import EstadosJogador.State;

public abstract class Mapa {

    private Jogador jogador;
    private int blocos[][];
    private int largura, altura;
    private int posJogadorX, posJogadorY;
    private State estadoJogador;

    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        blocos = new int[altura][largura];
        posJogadorX = 0;
        posJogadorY = 0;
        estadoJogador = null;
        jogador = null;
    }

    public void mover(Comando comando, Jogo jogo) {
        if (getEstadoJogador() instanceof EstadoMorto) { //Se morto, revive
            getEstadoJogador().doAction(this);
        } else {
            int posX = getPosJogadorX(), posY = getPosJogadorY();
            if (null != comando) {
                switch (comando) {
                    case ESQUERDA:
                        posX = getPosJogadorX() - 1;
                        break;
                    case DIREITA:
                        posX = getPosJogadorX() + 1;
                        break;
                    case CIMA:
                        posY = getPosJogadorY() - 1;
                        break;
                    case BAIXO:
                        posY = getPosJogadorY() + 1;
                        break;
                }
            }

            if (isPosicaoValida(posX, posY)) {
                int blockType = getBloco(posX, posY);
                if (blockType != 1 && blockType != 4) {
                    setPosJogadorX(posX);
                    setPosJogadorY(posY);
                }
            }
        }

        if (!isPosicaoValida()) { //Se posicao inválida, morre
            // Show a red plane when the user hits a bomb.
            jogo.showRedPlane();
            getEstadoJogador().doAction(this);
        }
    }

    protected boolean isPosicaoValida() {
        return blocos[posJogadorY][posJogadorX] == 0 || blocos[posJogadorY][posJogadorX] == 3 || blocos[posJogadorY][posJogadorX] == 4;
    }

    protected boolean isPosicaoValida(int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        if (x >= getLargura() || y >= getAltura()) {
            return false;
        }
        return true;
    }

    public abstract void setBlocos();

    public Jogador getJogador() {
        return jogador;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public int getPosJogadorX() {
        return posJogadorX;
    }

    public int getPosJogadorY() {
        return posJogadorY;
    }

    public State getEstadoJogador() {
        return estadoJogador;
    }

    public void setBloco(int x, int y, int tipo) {
        if (x >= largura || y >= altura) {
            return;
        }
        blocos[y][x] = tipo;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPosJogadorX(int posJogadorX) {
        this.posJogadorX = posJogadorX;
    }

    public void setPosJogadorY(int posJogadorY) {
        this.posJogadorY = posJogadorY;
    }

    public void setEstadoJogador(State estadoJogador) {
        this.estadoJogador = estadoJogador;
    }

    public int getBloco(int x, int y) {
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        return blocos[y][x];
    }

    @Override
    public String toString() {
        String retorno = "";

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if (j == posJogadorX && i == posJogadorY) {
                    retorno += "J ";
                } else {
                    retorno += blocos[i][j] + " ";
                }
            }
            retorno += "\n";
        }
        return retorno;
    }

}
