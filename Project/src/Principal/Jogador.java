package Principal;

/*
 * Jogador Singleton por se tratar de um jogo singleplayer.
 */
public class Jogador {

    private static Jogador instance;
    private static String nome;

    private Jogador(String nome) {
        Jogador.nome = nome;
    }

    public static Jogador getInstance(String nome) {
        if (instance == null) {
            instance = new Jogador(nome);
        } else if (!Jogador.nome.equals(nome)) {
            Jogador.setNome(nome);
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
