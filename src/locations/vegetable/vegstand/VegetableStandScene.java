package locations.vegetable.vegstand;

import commongui.PanelWithImage;
import commongui.Tools;
import locations.Scene;
import locations.SceneSwitcher;
import locations.vegetable.VegetableDepartmentLocation;

import java.io.IOException;
import java.util.Observable;

public class VegetableStandScene extends Observable implements Scene, SceneSwitcher {
    private PanelWithImage vegetablesScene;
    private VegetablesStandView standView;
    private VegetableDepartmentLocation parentPane;

    public VegetableStandScene(VegetableDepartmentLocation parentPane) {
        initScene();
        this.parentPane = parentPane;

        standView = new VegetablesStandView(this);

        VegetableStandPresenter standPresenter = new VegetableStandPresenter(new VegetablesStand());
        standView.setPresenter(standPresenter);
        placeObjectsOnScene();

        addObserver(new VegetableStandScenePresenter());
    }

    private void initScene() {
        try {
            vegetablesScene = Tools.getInstance().createScene("/locations/vegetable/img/vegBackground");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void placeObjectsOnScene() {
        PanelWithImage vegStandPanel = standView.getVegStandPanel();
        vegetablesScene.add(vegStandPanel);
        vegStandPanel.setBounds(202, 184, vegStandPanel.getWidth(), vegStandPanel.getHeight());

    }

    @Override
    public String getSceneID() {
        return "vegstand";
    }


    public void changeScene() {
        setChanged();
        notifyObservers();
    }

    public PanelWithImage getVegetablesScene() {
        return vegetablesScene;
    }


    public VegetableDepartmentLocation getParentPane() {
        return parentPane;
    }

    @Override
    public void sceneSwitched() {
        setChanged();
        notifyObservers("vegstand");
    }
}
