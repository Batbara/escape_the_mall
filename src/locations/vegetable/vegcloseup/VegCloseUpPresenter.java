package locations.vegetable.vegcloseup;

import locations.vegetable.VegetableDepartmentLocation;

import java.util.Observable;
import java.util.Observer;

public class VegCloseUpPresenter implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            VegetableDepartmentLocation parentLocation = ((VegCloseUpScene) o).getParentLocation();
            parentLocation.sceneChanged((String) arg);
        }
    }
}
