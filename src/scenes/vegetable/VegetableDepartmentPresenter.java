package scenes.vegetable;

import frames.PanelWithImage;
import scenes.vegetable.vegstand.VegetableStandScene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class VegetableDepartmentPresenter implements Observer {
    private Observable observableView;
    public VegetableDepartmentPresenter(VegetableStandScene observableView){
        this.observableView=observableView;
        observableView.addObserver(this);
    }
    void resetPicture(String name) throws IOException {
        String path = "/scenes/vegetable/img/"+name+".png";
        BufferedImage image = ImageIO.read(new File(this.getClass().getResource(path).getPath()));
        PanelWithImage scenesPanel =  ((VegetableStandScene)observableView).getVegetablesScene();
        scenesPanel.setImage(image);
    }
    private void clearScene(){
        VegetableStandScene vegetableStandScene = (VegetableStandScene)observableView;
        PanelWithImage scenePanel = vegetableStandScene.getVegetablesScene();
        Component[] componentList = scenePanel.getComponents();

        for(Component component : componentList){

            scenePanel.remove(component);
        }

        scenePanel.revalidate();
        scenePanel.repaint();
    }
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof VegetableStandScene){
            observableView = o;
            if(arg instanceof String){
                try {
                    resetPicture((String)arg);
                    clearScene();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
