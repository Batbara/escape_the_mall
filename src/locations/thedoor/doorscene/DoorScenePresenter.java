package locations.thedoor.doorscene;

import locations.thedoor.TheDoorLocation;

import java.util.Observable;
import java.util.Observer;

public class DoorScenePresenter implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            TheDoorLocation parentLocation = ((DoorScene) o).getParentLocation();
            parentLocation.sceneChanged((String) arg);
        }
    }
}
