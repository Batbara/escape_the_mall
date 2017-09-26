package commongui;
import javax.swing.*;
import java.awt.*;

public class PanelWithImage extends JComponent {
    private Image backgroundImage;

    public PanelWithImage(Image backgroundImage){
        this.backgroundImage =backgroundImage;
    }

    public void setImage(Image backgroundImage){
        this.backgroundImage = backgroundImage;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage,0,0,this);
    }
}
