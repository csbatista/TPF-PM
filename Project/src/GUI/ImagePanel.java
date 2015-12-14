package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class ImagePanel extends JPanel {

    private Image image;

    public ImagePanel(String image) {
        this(new ImageIcon(image).getImage());
    }

    public ImagePanel(Image img) {
        this.image = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setMinimumSize(size);
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

}
