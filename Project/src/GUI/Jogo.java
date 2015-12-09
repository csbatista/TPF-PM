package GUI;

import java.awt.*;

import javax.swing.*;

import Principal.*;
import java.awt.event.KeyListener;

public class Jogo extends JFrame {

    private JPanel contentPane;
    private Mapa mapinha;
    private KeyListener fase1;
    private KeyListener fase2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
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
                if (mapinha.getBloco(i, j) == 0) {
                    label.setIcon(new ImageIcon(getClass().getResource("vazio.png")));
                    //label.setBackground(new Color(255, 255, 255));
                    //label.setText(i+"_"+j+"0");
                }
                if (mapinha.getBloco(i, j) == 1) {
                    label.setIcon(new ImageIcon(getClass().getResource("tijolo.png")));
                    //label.setBackground(new Color(100, 100, 100));
                    //label.setText(i+"_"+j+"1");
                }
                if (mapinha.getBloco(i, j) == 2) {
                    label.setIcon(new ImageIcon(getClass().getResource("bomb.png")));
                    //label.setBackground(new Color(100, 100, 100));
                    //label.setText(i+"_"+j+"2");
                }
                if (mapinha.getBloco(i, j) == 3) {
                    label.setIcon(new ImageIcon(getClass().getResource("estrela.png")));
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

    public void mudaFase() {
        mapinha = new Mapa02();
        removeKeyListener(fase1);
        fase2 = new MKeyListener(mapinha, this);
        addKeyListener(fase2);
        atualizaGUI();
    }
}
