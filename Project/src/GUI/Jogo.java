package GUI;

import Jogador.Jogador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Mapas.*;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine.Info;
import javax.swing.JOptionPane;
import sun.applet.Main;

public class Jogo extends javax.swing.JFrame {

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
    
    private javax.swing.JMenu jMenuItem1;
    private javax.swing.JMenu jMenuItem2;
    private javax.swing.JMenu jMenuItem3;
    private javax.swing.JMenuBar jMenuBar;

    public void IniciaJogo() {
        Jogo frame = new Jogo();
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public Jogo() {
        tocarSom("newGame.wav");
        this.setTitle("This is the ONLY Level!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        setContentPane(contentPane);
        
        faseAtual = 1;
        mapa = new Mapa01();
        mapa.setJogador(Jogador.getInstance());
        listener = new MKeyListener(mapa, this);
        this.addKeyListener(listener);
        
        
        jMenuBar = new javax.swing.JMenuBar();
        jMenuItem1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenu();
        
        
        jMenuItem3 = new javax.swing.JMenu();
        jMenuItem3.setText("Nivel 1");
        jMenuItem3.setFocusable(false);
        jMenuItem3.setRolloverEnabled(false);
        jMenuBar.add(jMenuItem3);
        
        
        jMenuItem1.setText("Voltar Nivel");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(faseAtual > 1) {
                    mudarFase(false);
                }
            }
        });
        jMenuBar.add(jMenuItem1);
        
        jMenuItem2.setText("Sair");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });
        jMenuBar.add(jMenuItem2);

        setJMenuBar(jMenuBar);
        
        
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
                    label.setIcon(new ImageIcon(getClass().getResource("img//vazio.png")));
                }
                if (mapa.getBloco(i, j) == TIJOLO) {
                    label.setIcon(new ImageIcon(getClass().getResource("img//tijolo.png")));
                }
                if (mapa.getBloco(i, j) == BOMBA) {
                    label.setIcon(new ImageIcon(getClass().getResource("img//bomb.png")));
                }
                if (mapa.getBloco(i, j) == ESTRELA) {
                    label.setIcon(new ImageIcon(getClass().getResource("img//pirate_treasure.png")));
                }
                if (i == mapa.getPosJogadorX() && j == mapa.getPosJogadorY()) {
                    label.setIcon(new ImageIcon(getClass().getResource("img//user.png")));
                }
                contentPane.add(label);
            }
            GridLayout layout = new GridLayout(mapa.getAltura(), mapa.getLargura(), 0, 0);
            layout.setHgap(0);
            contentPane.setLayout(layout);
        }
    }

    public void mudarFase(boolean forward) {
        if(forward) {
            if (faseAtual == 1) mapa = new Mapa02();
            if (faseAtual == 2) mapa = new Mapa03();
            if (faseAtual == 3) mapa = new Mapa04();
            if (faseAtual == 4) mapa = new Mapa05();
            faseAtual++;
            
            tocarSom("newLevel.wav");
            JOptionPane.showMessageDialog(this, "Parabéns, você passou de fase!\nFase: " + faseAtual);
        }
        else {
            if (faseAtual == 2) mapa = new Mapa01();
            if (faseAtual == 3) mapa = new Mapa02();
            if (faseAtual == 4) mapa = new Mapa03();
            if (faseAtual == 5) mapa = new Mapa04();
            faseAtual--;
        }
        
        jMenuItem3.setText("Nivel " + faseAtual);
        removeKeyListener(listener);
        listener = new MKeyListener(mapa, this);
        addKeyListener(listener);
        atualizaGUI();
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
                    
                    System.out.println("URL: " + url);
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("audio//" + url));
                    AudioFormat format = inputStream.getFormat();
                    Info info = new Info(Clip.class, format);
                    Clip clip = (Clip)AudioSystem.getLine(info);
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

