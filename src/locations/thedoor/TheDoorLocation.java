package locations.thedoor;

import frames.PanelWithImage;
import locations.Location;
import locations.thedoor.doorscene.DoorScene;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class TheDoorLocation extends Observable implements Location{
    private JPanel container;
    private DoorScene doorScene;
    private Map<String, String> scenesOrder;
    public TheDoorLocation(){
        container = new JPanel(new GridLayout(1,1));
//        container.setSize(new Dimension(860,529));
//        container.setPreferredSize(container.getSize());
        //container.setBackground(Color.red);
        doorScene = new DoorScene(this);
        initScenesOrder();
        addScenesToContainer();
        addObserver(new TheDoorLocationPresenter(this));
    }

    private void initScenesOrder(){
        scenesOrder = new HashMap<>();
    }
    public void sceneChanged(String name){
        setChanged();
        notifyObservers(name);
    }
    private void addScenesToContainer(){
        container.add(doorScene.getDoorScenePanel());
    }
    @Override
    public Map<String, String> getScenesOrder() {
        return scenesOrder;
    }

    @Override
    public PanelWithImage getScenePanel(String sceneID) {
        switch (sceneID){
            case "thedoor":
                return doorScene.getDoorScenePanel();
        }
        return null;
    }

    @Override
    public String getLocationLabel() {
        return "Дверь";
    }

    @Override
    public JPanel getLocationContainer() {
        return container;
    }
}
