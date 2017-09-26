package locations.thedoor;

import commongui.PanelWithImage;
import locations.Location;
import locations.thedoor.doorscene.DoorScene;
import locations.thedoor.neardoor.NearDoorScene;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class TheDoorLocation extends Observable implements Location {
    private JPanel container;
    private DoorScene doorScene;
    private NearDoorScene nearDoorScene;
    private Map<String, String> scenesOrder;

    public TheDoorLocation() {
        container = new JPanel(new GridLayout(1, 1));
        doorScene = new DoorScene(this);
        nearDoorScene = new NearDoorScene(this);
        initScenesOrder();
        addScenesToContainer();
        addObserver(new TheDoorLocationPresenter(this));
    }

    private void initScenesOrder() {
        scenesOrder = new HashMap<>();
        scenesOrder.put(doorScene.getSceneID(), nearDoorScene.getSceneID());
        scenesOrder.put(nearDoorScene.getSceneID(), doorScene.getSceneID());
    }

    public void sceneChanged(String name) {
        setChanged();
        notifyObservers(name);
    }

    private void addScenesToContainer() {
        container.add(doorScene.getDoorScenePanel());
    }

    @Override
    public Map<String, String> getScenesOrder() {
        return scenesOrder;
    }

    @Override
    public PanelWithImage getScenePanel(String sceneID) {
        switch (sceneID) {
            case "doorscene":
                return doorScene.getDoorScenePanel();
            case "neardoor":
                return nearDoorScene.getNearDoorScenePanel();
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
