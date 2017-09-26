package frames;

import frames.PanelWithImage;
import locations.SceneSwitcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SceneSwitcherListener extends MouseAdapter{
    private SceneSwitcher view;
    public SceneSwitcherListener(SceneSwitcher view){
        this.view = view;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        view.sceneSwitched();
    }
    @Override
    public void mouseEntered(MouseEvent e){
        JComponent panel = (JComponent) e.getSource();
        panel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    }

}
