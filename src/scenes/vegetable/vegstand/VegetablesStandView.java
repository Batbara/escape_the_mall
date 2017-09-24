package scenes.vegetable.vegstand;

import frames.PanelWithImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

public class VegetablesStandView extends Observable {
    private PanelWithImage vegStandPanel;
    private VegetableStandPresenter presenter;
    private VegetableStandScene parentScene;

    public VegetablesStandView(VegetableStandScene parentScene) {
        try {
            initPanel("vegStand");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.parentScene = parentScene;
        vegStandPanel.addMouseListener(new CustomMouseListener(this));
    }

    public VegetableStandPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(VegetableStandPresenter presenter) {
        this.presenter = presenter;

        addObserver(presenter);
    }

    public void viewChanged() {
        setChanged();
        notifyObservers(true);
    }

    void initPanel(String fileName) throws IOException {
        String path = "/scenes/vegetable/img/" + fileName + ".png";

        BufferedImage background = ImageIO.read(new File(this.getClass().getResource(path).getPath()));
        vegStandPanel = new PanelWithImage(background);
        vegStandPanel.setSize(new Dimension(background.getWidth(), background.getHeight()));
    }

    public PanelWithImage getVegStandPanel() {
        return vegStandPanel;
    }

    public VegetableStandScene getParentScene() {
        return parentScene;
    }
}
