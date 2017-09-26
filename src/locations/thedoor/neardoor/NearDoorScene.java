package locations.thedoor.neardoor;

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

public class NearDoorScene extends Observable implements Scene, SceneSwitcher {
    private PanelWithImage nearDoorScenePanel;
    private TheDoorLocation parentLocation;

    public NearDoorScene(TheDoorLocation parentLocation) {
        initScene();
        this.parentLocation = parentLocation;
        placeObjectsOnScene();
        addObserver(new NearDoorScenePresenter());
    }

    private void initScene() {
        try {
            nearDoorScenePanel = Tools.getInstance().createPanel("/locations/thedoor/img/neardoor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JPanel createReturningArea() {
        JPanel returningArea = new JPanel();
        returningArea.setSize(new Dimension(nearDoorScenePanel.getWidth() - 60, 50));
        returningArea.setOpaque(false);
        returningArea.addMouseListener(new SceneSwitcherListener(this));
        return returningArea;
    }

    @Override
    public void placeObjectsOnScene() {
        JPanel returningArea = createReturningArea();
        nearDoorScenePanel.add(returningArea);
        returningArea.setBounds(35, nearDoorScenePanel.getHeight() - 50, returningArea.getWidth(), returningArea.getHeight());

    }

    @Override
    public String getSceneID() {
        return "neardoor";
    }

    @Override
    public void sceneSwitched() {
        setChanged();
        notifyObservers(getSceneID());
    }

    TheDoorLocation getParentLocation() {
        return parentLocation;
    }

    public PanelWithImage getNearDoorScenePanel() {
        return nearDoorScenePanel;
    }
}
