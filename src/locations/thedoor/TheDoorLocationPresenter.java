package locations.thedoor;

import commongui.PanelWithImage;

import javax.swing.*;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class TheDoorLocationPresenter implements Observer {
    private Observable observable;

    public TheDoorLocationPresenter(Observable observable) {
        this.observable = observable;
    }

    private void setScene(String name) {
        TheDoorLocation location = (TheDoorLocation) observable;
        JPanel locationContainer = location.getLocationContainer();
        PanelWithImage sceneToSet = location.getScenePanel(name);
        locationContainer.add(sceneToSet);
        locationContainer.revalidate();
        locationContainer.repaint();
    }

    private void removeChangedScene(String name) {
        TheDoorLocation location = (TheDoorLocation) observable;
        JPanel locationContainer = location.getLocationContainer();
        PanelWithImage sceneToRemove = location.getScenePanel(name);
        locationContainer.remove(sceneToRemove);
        locationContainer.revalidate();
        locationContainer.repaint();
    }

    @Override
    public void update(Observable o, Object arg) {
        String changedScene = (String) arg;
        removeChangedScene(changedScene);
        Map<String, String> scenesOrder = ((TheDoorLocation) observable).getScenesOrder();
        for (String key : scenesOrder.keySet()) {
            if (changedScene.equals(key)) {
                setScene(scenesOrder.get(key));
            }
        }
    }
}
