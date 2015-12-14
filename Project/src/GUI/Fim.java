
package GUI;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fim extends javax.swing.JFrame {

    private final JPanel contentPane;

    public Fim() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        setContentPane(contentPane);

        JLabel label = new JLabel();
        label.setMinimumSize(new Dimension(400, 400));
        label.setIcon(new ImageIcon(getClass().getResource("img//fundo2.png")));

        contentPane.add(label);
        setBounds(100, 100, 400, 400);
    }
}
