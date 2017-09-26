package locations.vegetable;

import frames.PanelWithImage;
import locations.Location;
import locations.vegetable.vegcloseup.VegCloseUpScene;
import locations.vegetable.vegstand.VegetableStandScene;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VegetableDepartmentLocation extends Observable implements Location {
    private JPanel container;
    private VegetableStandScene vegStandScene;
    private VegCloseUpScene vegCloseUpScene;
    private Map<String,String> scenesOrder;
    public VegetableDepartmentLocation(){
        container = new JPanel();
        vegStandScene = new VegetableStandScene(this);
        vegCloseUpScene = new VegCloseUpScene(this);
        initScenesOrder();
        addToContainer();
        addObserver(new VegetableDepartmentPresenter(this));
    }
    public void sceneChanged(String name){
        setChanged();
        notifyObservers(name);

    }
    private void initScenesOrder(){
        scenesOrder = new HashMap<>();
        scenesOrder.put(vegStandScene.getSceneID(),vegCloseUpScene.getSceneID());
        scenesOrder.put(vegCloseUpScene.getSceneID(),vegStandScene.getSceneID());
    }
    public JPanel getLocationContainer() {
        return container;
    }
    public String getLocationLabel() {
        return "Овощной отдел";
    }
    private void addToContainer(){
       // container.add(vegCloseUpScene.getCloseUpScenePanel());
        container.add(vegStandScene.getVegetablesScene());
    }

    public Map<String, String> getScenesOrder() {
        return scenesOrder;
    }
    public PanelWithImage getScenePanel(String sceneID){
        switch (sceneID){
            case "vegcloseup":
                return vegCloseUpScene.getCloseUpScenePanel();
            case "vegstand":
                return vegStandScene.getVegetablesScene();
        }
        return null;
    }
}
