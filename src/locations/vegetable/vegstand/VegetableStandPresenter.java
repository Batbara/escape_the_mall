package locations.vegetable.vegstand;

import locations.vegetable.VegetableDepartmentLocation;

import java.util.Observable;
import java.util.Observer;

public class VegetableStandPresenter implements Observer {
    private VegetablesStand model;

    public VegetableStandPresenter(VegetablesStand model) {
        this.model = model;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            VegetableDepartmentLocation parentLocation = ((VegetablesStandView) o).getParentScene().getParentPane();
            parentLocation.sceneChanged((String) arg);
        }

    }
}
