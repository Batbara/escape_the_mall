package frames;
import javax.swing.*;
import java.awt.*;

public class BackgroundImage extends JComponent {
    private Image background;

    public BackgroundImage(Image background){
        this.background=background;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background,0,0,this);
    }
}
