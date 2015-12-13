 package GUI;

import Mapas.*;
import java.awt.*;

import javax.swing.*;

import Principal.*;
import java.awt.event.KeyListener;

public class Jogo extends JFrame {

    final int VAZIO = 0;
    final int TIJOLO = 1;
    final int BOMBA = 2;
    final int ESTRELA = 3;
    final int TIJOLO_ESCONDIDO = 4;
    final int BOMBA_ESCONDIDA = 5;
    
    private JPanel contentPane;
    private Mapa mapinha;
    private KeyListener fase1;
    private KeyListener fase2;
    private KeyListener fase3;
    private KeyListener fase4;

    /**
     * Launch the application.
     */
    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Jogo frame = new Jogo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/
    public void IniciaJogo(){
        Jogo frame = new Jogo();
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public Jogo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        //contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        mapinha = new Mapa01();
        mapinha.setJogador(Jogador.getInstance("Pedro"));
        fase1 = new MKeyListener(mapinha, this);
        this.addKeyListener(fase1);

        atualizaGUI();
    }

    public void atualizaGUI() {
        //System.out.println("Atualizando mapa");
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        setBounds(100, 100, mapinha.getAltura() * 50, mapinha.getLargura() * 50);
        for (int j = 0; j < mapinha.getLargura(); j++) {
            for (int i = 0; i < mapinha.getAltura(); i++) {
                JLabel label = new JLabel();
                label.setMinimumSize(new Dimension(100, 100));
                //label.setMaximumSize(new Dimension (100,100));
                //label.setMinimumSize(new Dimension (100,100));
                //label.setText(Integer.toString(mapa.getBloco(i, j)));
                if (mapinha.getBloco(i, j) == VAZIO || mapinha.getBloco(i, j) == TIJOLO_ESCONDIDO || mapinha.getBloco(i, j) == BOMBA_ESCONDIDA) {
                    label.setIcon(new ImageIcon(getClass().getResource("vazio.png")));
                    //label.setBackground(new Color(255, 255, 255));
                    //label.setText(i+"_"+j+"0");
                }
                if (mapinha.getBloco(i, j) == TIJOLO) {
                    label.setIcon(new ImageIcon(getClass().getResource("tijolo.png")));
                    //label.setBackground(new Color(100, 100, 100));
                    //label.setText(i+"_"+j+"1");
                }
                if (mapinha.getBloco(i, j) == BOMBA) {
                    label.setIcon(new ImageIcon(getClass().getResource("bomb.png")));
                    //label.setBackground(new Color(100, 100, 100));
                    //label.setText(i+"_"+j+"2");
                }
                if (mapinha.getBloco(i, j) == ESTRELA) {
                    label.setIcon(new ImageIcon(getClass().getResource("pirate_treasure.png")));
                    //label.setBackground(new Color(100, 100, 100));
                    //label.setText(i+"_"+j+"2");
                }
                if (i == mapinha.getPosJogadorX() && j == mapinha.getPosJogadorY()) {
                    //retorno += "J ";
                    label.setIcon(new ImageIcon(getClass().getResource("user.png")));
                    //label.setBackground(new Color(100, 100, 100));
                    //label.setText(i+"_"+j+"2");
                }
                contentPane.add(label);
            }
            GridLayout layout = new GridLayout(mapinha.getAltura(), mapinha.getLargura(), 0, 0);
            layout.setHgap(0);
            contentPane.setLayout(layout);
        }
    }

    public void mudaFase02() {
        mapinha = new Mapa02();
        removeKeyListener(fase1);
        fase2 = new MKeyListener(mapinha, this);
        addKeyListener(fase2);
        atualizaGUI();
    }
    
    public void mudaFase03() {
        mapinha = new Mapa03();
        removeKeyListener(fase2);
        fase3 = new MKeyListener(mapinha, this);
        addKeyListener(fase3);
        atualizaGUI();
    }
    
    public void mudaFase04() {
        mapinha = new Mapa04();
        removeKeyListener(fase3);
        fase4 = new MKeyListener(mapinha, this);
        addKeyListener(fase4);
        atualizaGUI();
    }
}
