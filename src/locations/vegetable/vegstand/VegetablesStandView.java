package locations.vegetable.vegstand;

import frames.PanelWithImage;
import frames.Tools;

import java.io.IOException;
import java.util.Observable;

public class VegetablesStandView extends Observable {
    private PanelWithImage vegStandPanel;
    private VegetableStandPresenter presenter;
    private VegetableStandScene parentScene;

    public VegetablesStandView(VegetableStandScene parentScene) {
        initPanel();
        this.parentScene = parentScene;
        vegStandPanel.addMouseListener(new VegStandListener(this));
    }

    public VegetableStandPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(VegetableStandPresenter presenter) {
        this.presenter = presenter;

        addObserver(presenter);
    }

    public void viewChanged() {
        setChanged();
        notifyObservers(true);
    }

    private void initPanel()  {
        try {
            vegStandPanel = Tools.getInstance().createPanel("/locations/vegetable/img/vegStand");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PanelWithImage getVegStandPanel() {
        return vegStandPanel;
    }

    public VegetableStandScene getParentScene() {
        return parentScene;
    }
}
