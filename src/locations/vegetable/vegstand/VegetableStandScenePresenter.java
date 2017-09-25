package locations.vegetable.vegstand;

import frames.PanelWithImage;
import locations.vegetable.VegetableDepartmentLocation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class VegetableStandScenePresenter implements Observer {
    private Observable observableView;
    public VegetableStandScenePresenter(VegetableStandScene observableView){
        this.observableView=observableView;
        observableView.addObserver(this);
    }

    private void removePanel(){
        VegetableStandScene vegetableStandScene = (VegetableStandScene)observableView;
        VegetableDepartmentLocation parentLocation = vegetableStandScene.getParentPane();
        parentLocation.sceneChanged(vegetableStandScene.getSceneID());
        JPanel parentPane = parentLocation.getContainer();
        parentPane.remove(vegetableStandScene.getVegetablesScene());
        parentPane.revalidate();
        parentPane.repaint();

    }
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof VegetableStandScene){
            observableView = o;

               removePanel();

        }
    }
}
