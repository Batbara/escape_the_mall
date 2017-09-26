package locations.vegetable.vegstand;

import locations.vegetable.VegetableDepartmentLocation;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class VegetableStandScenePresenter implements Observer {
    private Observable observableView;
    public VegetableStandScenePresenter(VegetableStandScene observableView){
        this.observableView=observableView;
        observableView.addObserver(this);
    }

    private void removePanel(){
        VegetableStandScene vegetableStandScene = (VegetableStandScene)observableView;
        VegetableDepartmentLocation parentLocation = vegetableStandScene.getParentPane();
        parentLocation.sceneChanged(vegetableStandScene.getSceneID());
        JPanel parentPane = parentLocation.getLocationContainer();
        parentPane.remove(vegetableStandScene.getVegetablesScene());
        parentPane.revalidate();
        parentPane.repaint();

    }
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof VegetableStandScene){
            observableView = o;

               removePanel();

        }
    }
}
