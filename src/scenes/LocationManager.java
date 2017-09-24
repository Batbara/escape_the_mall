package scenes;

import scenes.vegetable.vegstand.VegetableStandScene;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class LocationManager {
    private JPanel gamePane;
    private JPanel scenesHolder;
    private LocationSwitcher locationSwitcher;
    private VegetableStandScene vegetableStandScene;
    public LocationManager(){
        initMainPanel();
        initScenes();
        initScenesHolder();

        Vector<String> scenesNamesList = new Vector<>();
        scenesNamesList.add(vegetableStandScene.getSceneLabel());
        locationSwitcher = new LocationSwitcher(scenesNamesList);
        locationSwitcher.assignListener(this);
        addToMainScene();
    }
    private void initMainPanel(){
        gamePane = new JPanel(new BorderLayout());
    }
    private void initScenes(){
        vegetableStandScene = new VegetableStandScene();
    }
    private void initScenesHolder(){
         scenesHolder = new JPanel(new CardLayout());
        //scenesHolder = place all scenes on this panel
        scenesHolder.add(vegetableStandScene.getVegetablesScene(), vegetableStandScene.getSceneLabel());
    }
    private void addToMainScene(){

        gamePane.add(locationSwitcher.getSwitcherContainer(),BorderLayout.PAGE_START);
        gamePane.add(scenesHolder,BorderLayout.CENTER);
    }

    public JPanel getScenesHolder() {
        return scenesHolder;
    }

    public JPanel getGamePane() {
        return gamePane;
    }
}
