package locations.vegetable.vegstand;

import commongui.PanelWithImage;
import commongui.SceneSwitcherListener;
import commongui.Tools;
import locations.SceneSwitcher;

import java.io.IOException;
import java.util.Observable;

public class VegetablesStandView extends Observable implements SceneSwitcher {
    private PanelWithImage vegStandPanel;
    private VegetableStandScene parentScene;

    VegetablesStandView(VegetableStandScene parentScene) {
        initPanel();
        this.parentScene = parentScene;
        vegStandPanel.addMouseListener(new SceneSwitcherListener(this));
    }

    void setPresenter(VegetableStandPresenter presenter) {
        addObserver(presenter);
    }

    public void sceneSwitched() {
        setChanged();
        notifyObservers(parentScene.getSceneID());
    }

    private void initPanel() {
        try {
            vegStandPanel = Tools.getInstance().createPanel("/locations/vegetable/img/vegStand");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    PanelWithImage getVegStandPanel() {
        return vegStandPanel;
    }

    VegetableStandScene getParentScene() {
        return parentScene;
    }
}
