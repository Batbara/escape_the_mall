package locations.vegetable.vegcloseup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReturningAreaListener extends MouseAdapter{
    VegCloseUpScene vegCloseUpScene;
    public ReturningAreaListener(VegCloseUpScene vegCloseUpScene){
        this.vegCloseUpScene =vegCloseUpScene;
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        JPanel panel = (JPanel) e.getSource();
        panel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        vegCloseUpScene.switchScene();
    }
}
