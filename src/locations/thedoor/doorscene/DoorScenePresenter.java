package locations.thedoor.doorscene;

import locations.thedoor.TheDoorLocation;

import java.util.Observable;
import java.util.Observer;

public class DoorScenePresenter implements Observer{
    private Observable observable;
    public DoorScenePresenter(Observable observable){
        this.observable = observable;
    }
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof String){
            TheDoorLocation parentLocation = ((DoorScene)observable).getParentLocation();
            parentLocation.sceneChanged("vegcloseup");
        }
    }
}
