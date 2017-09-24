package locations.vegetable.vegcloseup;

import frames.PanelWithImage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LemonzMouseListener extends MouseAdapter {
    public LemonzMouseListener(){

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        PanelWithImage lemonzPanel = (PanelWithImage)e.getSource();
        //TODO: start quest
    }
}
