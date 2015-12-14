package Jogador;

/*
 * Jogador Singleton por se tratar de um jogo singleplayer.
 */
public class Jogador {

    private static Jogador instance;
    private static String nome;

    private Jogador() {
        Jogador.nome = "Player";
    }

    public static Jogador getInstance() {
        if (instance == null) {
            instance = new Jogador();
        }
        return instance;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Jogador.nome = nome;
    }

}
