package locations.vegetable.vegstand;

import frames.PanelWithImage;
import frames.Tools;
import locations.Scene;
import locations.vegetable.VegetableDepartmentLocation;

import java.io.IOException;
import java.util.Observable;

public class VegetableStandScene extends Observable implements Scene {
    private PanelWithImage vegetablesScene;
    private VegetablesStandView standView;
    private VegetableDepartmentLocation parentPane;

    public VegetableStandScene(VegetableDepartmentLocation parentPane) {
        initScene();
        this.parentPane = parentPane;

        standView = new VegetablesStandView(this);

        VegetableStandPresenter standPresenter = new VegetableStandPresenter(new VegetablesStand(), standView);
        standView.setPresenter(standPresenter);
        placeObjectsOnScene();

        addObserver(new VegetableStandScenePresenter(this));
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
}
