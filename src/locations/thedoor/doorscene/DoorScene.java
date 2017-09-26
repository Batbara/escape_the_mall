package locations.thedoor.doorscene;

import commongui.PanelWithImage;
import commongui.SceneSwitcherListener;
import commongui.Tools;
import locations.Scene;
import locations.SceneSwitcher;
import locations.thedoor.TheDoorLocation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;

public class DoorScene extends Observable implements Scene, SceneSwitcher {
    private class DoorHandle {
        private JPanel doorHandlePanel;

        DoorHandle() {
            initHandlePanel();
            doorHandlePanel.addMouseListener(new SceneSwitcherListener(DoorScene.this));
        }

        private void initHandlePanel() {
            doorHandlePanel = new JPanel();
            doorHandlePanel.setSize(new Dimension(50, 80));
            doorHandlePanel.setPreferredSize(doorHandlePanel.getSize());

            doorHandlePanel.setOpaque(false);
        }

    }

    private PanelWithImage doorScenePanel;
    private TheDoorLocation parentLocation;

    public DoorScene(TheDoorLocation parentLocation) {
        initScenePanel();
        this.parentLocation = parentLocation;
        placeObjectsOnScene();
        addObserver(new DoorScenePresenter());

    }

    private void initScenePanel() {
        try {
            doorScenePanel = Tools.getInstance().createPanel("/locations/thedoor/img/door");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    TheDoorLocation getParentLocation() {
        return parentLocation;
    }

    @Override
    public void placeObjectsOnScene() {
        DoorScene.DoorHandle doorHandle = this.new DoorHandle();
        JPanel handlePanel = doorHandle.doorHandlePanel;
        handlePanel.setBounds(348, 265, handlePanel.getWidth(), handlePanel.getHeight());
        doorScenePanel.add(handlePanel);

    }

    @Override
    public String getSceneID() {
        return "doorscene";
    }

    @Override
    public void sceneSwitched() {
        setChanged();
        notifyObservers(getSceneID());
    }

    public PanelWithImage getDoorScenePanel() {
        return doorScenePanel;
    }

}
