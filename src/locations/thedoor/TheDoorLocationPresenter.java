package locations.thedoor;

import java.util.Observable;
import java.util.Observer;

public class TheDoorLocationPresenter implements Observer {
    private Observable observable;
    public TheDoorLocationPresenter(Observable observable){
        this.observable = observable;
    }
    @Override
    public void update(Observable o, Object arg) {

    }
}
