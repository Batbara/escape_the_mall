package locations.vegetable.vegcloseup;

import locations.vegetable.VegetableDepartmentLocation;

import java.util.Observable;
import java.util.Observer;

public class VegCloseUpPresenter implements Observer {
    private Observable observable;
    public VegCloseUpPresenter(Observable observable){
        this.observable = observable;
    }
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof String){
            VegetableDepartmentLocation parentLocation = ((VegCloseUpScene)observable).getParentLocation();
            parentLocation.sceneChanged((String)arg);
        }
    }
}
