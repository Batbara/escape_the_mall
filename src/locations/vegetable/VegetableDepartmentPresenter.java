package locations.vegetable;

import frames.PanelWithImage;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class VegetableDepartmentPresenter implements Observer{
    Observable observable;
    public VegetableDepartmentPresenter(VegetableDepartmentLocation observable){
        this.observable = observable;
    }
    private void setScene(String name){
        VegetableDepartmentLocation location = (VegetableDepartmentLocation)observable;
        JPanel locationContainer = location.getContainer();
        PanelWithImage sceneToSet = location.getScenePanel(name);
        locationContainer.add(sceneToSet);
        locationContainer.revalidate();
        locationContainer.repaint();
    }
    private void removeChangedScene(String name){
        VegetableDepartmentLocation location = (VegetableDepartmentLocation)observable;
        JPanel locationContainer = location.getContainer();
        PanelWithImage sceneToRemove = location.getScenePanel(name);
        locationContainer.remove(sceneToRemove);
        locationContainer.revalidate();
        locationContainer.repaint();
    }
    @Override
    public void update(Observable o, Object arg) {
        observable = o;
        String changedScene = (String)arg;
        removeChangedScene(changedScene);
        Map<String,String> scenesOrder = ((VegetableDepartmentLocation)observable).getScenesOrder();
        for (String key : scenesOrder.keySet()){
            if(changedScene.equals(key)){
                setScene(scenesOrder.get(key));
            }
        }
    }
}
