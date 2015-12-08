package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Principal.Mapa01;

public class Jogo extends JFrame {

	private JPanel contentPane;

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
		
		Mapa01 mapa = new Mapa01();
		setBounds(100, 100,mapa.getAltura()*50, mapa.getLargura()*50);
		for (int j = 0; j < mapa.getLargura(); j++){
            for (int i = 0; i < mapa.getAltura(); i++){
            	JLabel label = new JLabel();
            	label.setMinimumSize(new Dimension (100,100));
            	//label.setMaximumSize(new Dimension (100,100));
            	//label.setMinimumSize(new Dimension (100,100));
            	//label.setText(Integer.toString(mapa.getBloco(i, j)));
            	if (mapa.getBloco(i, j) == 0){
            		label.setIcon(new ImageIcon(getClass().getResource("vazio.png")));
            		//label.setBackground(new Color(255, 255, 255));
            		//label.setText(i+"_"+j+"0");
            	}
            	if (mapa.getBloco(i, j) == 1){
            		label.setIcon(new ImageIcon(getClass().getResource("tijolo.png")));
            		//label.setBackground(new Color(100, 100, 100));
            		//label.setText(i+"_"+j+"1");
            	}
            	if (mapa.getBloco(i, j) == 2){
            		label.setIcon(new ImageIcon(getClass().getResource("bomb.png")));
            		//label.setBackground(new Color(100, 100, 100));
            		//label.setText(i+"_"+j+"2");
            	}
            	if(j == mapa.getPosJogadorX() && i == mapa.getPosJogadorY()) {
                    //retorno += "J ";
                
            		label.setIcon(new ImageIcon(getClass().getResource("user.png")));
            		//label.setBackground(new Color(100, 100, 100));
            		//label.setText(i+"_"+j+"2");
            	}
            	
            	contentPane.add(label);
            	
            }
            
		}
		GridLayout layout = new GridLayout(mapa.getAltura(), mapa.getLargura(), 0, 0);
        layout.setHgap(0);
    	contentPane.setLayout(layout);
            
	}

}
