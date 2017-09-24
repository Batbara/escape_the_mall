package scenes.vegetable.vegstand;

import frames.PanelWithImage;
import scenes.vegetable.VegetableDepartmentPresenter;
import scenes.vegetable.vegstand.VegetableStandPresenter;
import scenes.vegetable.vegstand.VegetablesStand;
import scenes.vegetable.vegstand.VegetablesStandView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

public class VegetableStandScene extends Observable{
    private PanelWithImage vegetablesScene;
    private VegetablesStandView standView;
    private VegetableDepartmentPresenter scenePresenter;
    public VegetableStandScene(){
        try {
            initScene("vegBackground");
        } catch (IOException e) {
            e.printStackTrace();
        }
        standView = new VegetablesStandView(this);

        VegetableStandPresenter standPresenter = new VegetableStandPresenter(new VegetablesStand(),standView);
        standView.setPresenter(standPresenter);
        placeVegStand();

       scenePresenter = new VegetableDepartmentPresenter(this);
       addObserver(standPresenter);
    }
    private void initScene(String fileName) throws IOException {
        String path = "/scenes/vegetable/img/"+fileName+".png";
        Image background = ImageIO.read(new File(this.getClass().getResource(path).getPath()));
        vegetablesScene =  new PanelWithImage(background);
        vegetablesScene.setSize(new Dimension(860,529));
        vegetablesScene.setPreferredSize(vegetablesScene.getSize());
        vegetablesScene.setLayout(null);
        //vegetablesScene.setBorder(new BevelBorder(Color.red));
    }
    private void placeVegStand(){
        PanelWithImage vegStandPanel = standView.getVegStandPanel();
        vegetablesScene.add(vegStandPanel);
        vegStandPanel.setBounds(202,184,vegStandPanel.getWidth(),vegStandPanel.getHeight());

    }


    public void changeBackground(String fileName){
        setChanged();
        notifyObservers(fileName);
    }
    public PanelWithImage getVegetablesScene() {
        return vegetablesScene;
    }
    public String getSceneLabel(){
        return "Овощной отдел";
    }
}
