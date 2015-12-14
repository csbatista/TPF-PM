package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Mapas.*;
import Principal.*;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import sun.applet.Main;

public class Jogo extends JFrame {

    private final int VAZIO = 0;
    private final int TIJOLO = 1;
    private final int BOMBA = 2;
    private final int ESTRELA = 3;
    private final int TIJOLO_ESCONDIDO = 4;
    private final int BOMBA_ESCONDIDA = 5;
    private int faseAtual;
    
    private JPanel contentPane;
    private Mapa mapa;
    private KeyListener listener;

    public void IniciaJogo() {
        Jogo frame = new Jogo();
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public Jogo() {
        this.setTitle("This is the ONLY Level!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        setContentPane(contentPane);
        
        faseAtual = 1;
        mapa = new Mapa01();
        mapa.setJogador(Jogador.getInstance("Pedro"));
        listener = new MKeyListener(mapa, this);
        this.addKeyListener(listener);

        atualizaGUI();
    }

    public void atualizaGUI() {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();
        setBounds(100, 100, mapa.getAltura() * 50, mapa.getLargura() * 50);
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

    public void mudarFase() {
        if (faseAtual == 1) mapa = new Mapa02();
        if (faseAtual == 2) mapa = new Mapa03();
        if (faseAtual == 3) mapa = new Mapa04();
        if (faseAtual == 4) mapa = new Mapa05();
        removeKeyListener(listener);
        listener = new MKeyListener(mapa, this);
        addKeyListener(listener);
        atualizaGUI();
        faseAtual++;
        tocarSom("applause-8.wav");
        JOptionPane.showMessageDialog(this, "Parabéns, você passou de fase!\nFase: " + faseAtual);
    }

    public void showRedPlane() {
        tocarSom("explosion.wav");
        BufferedImage bi = new BufferedImage(mapa.getLargura() * 50,
                mapa.getAltura() * 50,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        g.setColor(new Color(255, 0, 0));
        g.fillRect(0, 0, mapa.getLargura() * 50, mapa.getAltura() * 50);
        g.drawImage(bi, 0, 0, mapa.getLargura() * 50, mapa.getAltura() * 50, null);
        g.dispose();

        Graphics cpaneGraphics = contentPane.getGraphics();
        cpaneGraphics.drawImage(bi, 0, 0, null);
        cpaneGraphics.dispose();
        contentPane.repaint();
    }
    
    public static synchronized void tocarSom(final String url) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(url));
                    clip.open(inputStream);
                    clip.start(); 
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}

