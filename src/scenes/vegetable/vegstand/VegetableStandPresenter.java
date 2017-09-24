package scenes.vegetable.vegstand;

import java.util.Observable;
import java.util.Observer;

public class VegetableStandPresenter implements Observer {
    private Observable observableView;
    private VegetablesStand model;

    public VegetableStandPresenter(VegetablesStand model, Observable observableView) {
        this.model = model;
        this.observableView = observableView;
        observableView.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof VegetablesStandView) {
           observableView=o;
            Boolean isPressed = (Boolean) arg;
            if (isPressed) {
                model.setPressedStatus(true);

                   VegetableStandScene mainScene=((VegetablesStandView)observableView).getParentScene();
                   mainScene.changeBackground("vegcloseup");
            }
        }

    }
}
