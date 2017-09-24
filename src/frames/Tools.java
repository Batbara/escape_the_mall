package frames;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tools {
    private static final Tools instance = new Tools();

    public static Tools getInstance(){
        return instance;
    }
    private Tools(){}
    public PanelWithImage createScene(String fileName) throws IOException {
        String path = fileName+".png";
        Image background = ImageIO.read(new File(this.getClass().getResource(path).getPath()));
        PanelWithImage panel =  new PanelWithImage(background);
        panel.setSize(new Dimension(860,529));
        panel.setPreferredSize(panel.getSize());
        panel.setLayout(null);
        //vegetablesScene.setBorder(new BevelBorder(Color.red));
        return panel;
    }
    public PanelWithImage createPanel(String fileName) throws IOException {

            String path = fileName + ".png";

            BufferedImage background = ImageIO.read(new File(this.getClass().getResource(path).getPath()));
            PanelWithImage panel = new PanelWithImage(background);
            panel.setSize(new Dimension(background.getWidth(), background.getHeight()));
            return panel;

    }
}
