package locations.vegetable.vegstand;

import frames.PanelWithImage;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomMouseListener extends MouseAdapter{
    private VegetablesStandView standView;
    public CustomMouseListener(VegetablesStandView standView){
        this.standView = standView;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        standView.viewChanged();
    }
    @Override
    public void mouseEntered(MouseEvent e){
        PanelWithImage panel = (PanelWithImage)e.getSource();
        panel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    }

}
