package locations.vegetable.vegcloseup;

import com.sun.deploy.util.LinkMouseListener;
import frames.PanelWithImage;
import frames.Tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

public class LemonzView extends Observable {
    private PanelWithImage lemonzPanel;
    public LemonzView(){
        initPanel();
        lemonzPanel.addMouseListener(new LemonzMouseListener());

    }
    private void initPanel(){
        try {
            lemonzPanel= Tools.getInstance().createPanel("/locations/vegetable/img/lemonz");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PanelWithImage getLemonzPanel() {
        return lemonzPanel;
    }
}
