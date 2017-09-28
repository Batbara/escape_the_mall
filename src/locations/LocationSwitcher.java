package locations;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

class LocationSwitcher {
    private JPanel switcherContainer;
    private List<String> labels;
    private JComboBox switchingBox;

    LocationSwitcher(List<String> labels) {
        this.labels = labels;
        switcherContainer = new JPanel();
        initComboBox();
        addToContainer();
    }

    private void initComboBox() {
        switchingBox = new JComboBox(new Vector(labels));
    }

    private void addToContainer() {
        switcherContainer.add(new Label("Локация:"));
        switcherContainer.add(switchingBox);
    }

    JPanel getSwitcherContainer() {
        return switcherContainer;
    }

    void assignListener(LocationManager locationManager) {

        switchingBox.addItemListener(new SwitchItemListener(locationManager));
    }
}
