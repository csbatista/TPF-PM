/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/*
Jogador Singleton por se tratar de um jogo singleplayer.
*/

public class Jogador {
    
    private static Jogador instance;
    private static String nome;
    
    private Jogador(String nome){
        this.nome = nome;
    }
    
    public static Jogador getInstance(String nome){
        if(instance == null){
            instance = new Jogador(nome);
        }else if(!Jogador.nome.equals(nome)){
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
