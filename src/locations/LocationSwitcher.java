package locations;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class LocationSwitcher {
    private JPanel switcherContainer;
    private Vector<String> labels;
    private JComboBox switchingBox;
    public LocationSwitcher(Vector<String> labels){
        this.labels = labels;
        switcherContainer = new JPanel();
        initComboBox();
        addToContainer();
    }
    private void initComboBox(){
        switchingBox = new JComboBox(labels);
    }
    private void addToContainer(){
        switcherContainer.add(new Label("Локация:"));
        switcherContainer.add(switchingBox);
    }

    public JPanel getSwitcherContainer() {
        return switcherContainer;
    }
    public void assignListener(LocationManager locationManager){

        switchingBox.addItemListener(new SwitchItemListener(locationManager));
    }
}
