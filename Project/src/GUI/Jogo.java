package GUI;

import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Mapas.*;
import Principal.*;

public class Jogo extends JFrame {

    final int VAZIO = 0;
    final int TIJOLO = 1;
    final int BOMBA = 2;
    final int ESTRELA = 3;
    final int TIJOLO_ESCONDIDO = 4;
    final int BOMBA_ESCONDIDA = 5;

    private final JPanel contentPane;
    private Mapa mapa;
    private KeyListener fase1;
    private KeyListener fase2;
    private KeyListener fase3;
    private KeyListener fase4;
    private KeyListener fase5;

    public void IniciaJogo() {
        Jogo frame = new Jogo();
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public Jogo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        setContentPane(contentPane);

        mapa = new Mapa01();
        mapa.setJogador(Jogador.getInstance("Pedro"));
        fase1 = new MKeyListener(mapa, this);
        this.addKeyListener(fase1);

        atualizaGUI();
    }

    public void atualizaGUI() {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        setBounds(100, 100, mapa.getAltura() * 50, mapa.getLargura() * 50);
        // ImagePanel image = new ImagePanel(new
        // ImageIcon("fundoo.jpg").getImage());
        // contentPane.add(image);
        // contentPane.setVisible(true);
        contentPane.setBackground(Color.white);

        for (int j = 0; j < mapa.getLargura(); j++) {
            for (int i = 0; i < mapa.getAltura(); i++) {
                JLabel label = new JLabel();
                label.setMinimumSize(new Dimension(100, 100));
                if (mapa.getBloco(i, j) == VAZIO || mapa.getBloco(i, j) == TIJOLO_ESCONDIDO
                        || mapa.getBloco(i, j) == BOMBA_ESCONDIDA) {
                    label.setIcon(new ImageIcon(getClass().getResource("vazio.png")));
                }
                if (mapa.getBloco(i, j) == TIJOLO) {
                    label.setIcon(new ImageIcon(getClass().getResource("tijolo.png")));
                }
                if (mapa.getBloco(i, j) == BOMBA) {
                    label.setIcon(new ImageIcon(getClass().getResource("bomb.png")));
                }
                if (mapa.getBloco(i, j) == ESTRELA) {
                    label.setIcon(new ImageIcon(getClass().getResource("pirate_treasure.png")));
                }
                if (i == mapa.getPosJogadorX() && j == mapa.getPosJogadorY()) {
                    label.setIcon(new ImageIcon(getClass().getResource("user.png")));
                }
                contentPane.add(label);
            }
            GridLayout layout = new GridLayout(mapa.getAltura(), mapa.getLargura(), 0, 0);
            layout.setHgap(0);
            contentPane.setLayout(layout);
        }
    }

    public void mudaFase02() {
        mapa = new Mapa02();
        removeKeyListener(fase1);
        fase2 = new MKeyListener(mapa, this);
        addKeyListener(fase2);
        atualizaGUI();
    }

    public void mudaFase03() {
        mapa = new Mapa03();
        removeKeyListener(fase2);
        fase3 = new MKeyListener(mapa, this);
        addKeyListener(fase3);
        atualizaGUI();
    }

    public void mudaFase04() {
        mapa = new Mapa04();
        removeKeyListener(fase3);
        fase4 = new MKeyListener(mapa, this);
        addKeyListener(fase4);
        atualizaGUI();
    }
    
    public void mudaFase05() {
        mapa = new Mapa05();
        removeKeyListener(fase4);
        fase5 = new MKeyListener(mapa, this);
        addKeyListener(fase5);
        atualizaGUI();
    }
}
