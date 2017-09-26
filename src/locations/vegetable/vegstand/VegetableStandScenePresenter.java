package locations.vegetable.vegstand;

import locations.vegetable.VegetableDepartmentLocation;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class VegetableStandScenePresenter implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            VegetableDepartmentLocation parentLocation = ((VegetableStandScene) o).getParentPane();
            parentLocation.sceneChanged((String) arg);
        }
    }
}
