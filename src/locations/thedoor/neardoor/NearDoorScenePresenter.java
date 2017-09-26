package locations.thedoor.neardoor;

import locations.thedoor.TheDoorLocation;

import java.util.Observable;
import java.util.Observer;

public class NearDoorScenePresenter implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            TheDoorLocation parentLocation = ((NearDoorScene) o).getParentLocation();
            parentLocation.sceneChanged((String) arg);
        }
    }
}
