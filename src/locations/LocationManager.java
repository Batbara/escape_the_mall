package locations;

import locations.thedoor.TheDoorLocation;
import locations.vegetable.VegetableDepartmentLocation;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class LocationManager {
    private JPanel gamePane;
    private JPanel locationsHolder;
    private LocationSwitcher locationSwitcher;
    private VegetableDepartmentLocation vegDptLocation;
    private TheDoorLocation theDoorLocation;

    public LocationManager() {
        initMainPanel();
        initLocations();
        initLocationsHolder();
        locationSwitcher = new LocationSwitcher(getLocationsNames());
        locationSwitcher.assignListener(this);
        addToGamePane();
    }

    private void initMainPanel() {
        gamePane = new JPanel(new BorderLayout());
    }

    private void initLocations() {
        vegDptLocation = new VegetableDepartmentLocation();
        theDoorLocation = new TheDoorLocation();
    }

    private void initLocationsHolder() {
        locationsHolder = new JPanel(new CardLayout());
        locationsHolder.setSize(new Dimension(860, 529));
        locationsHolder.setPreferredSize(locationsHolder.getSize());
        locationsHolder.setMaximumSize(locationsHolder.getSize());
        //locationsHolder = place all locations on this panel
        locationsHolder.add(vegDptLocation.getLocationContainer(), vegDptLocation.getLocationLabel());
        locationsHolder.add(theDoorLocation.getLocationContainer(), theDoorLocation.getLocationLabel());
    }

    private Vector<String> getLocationsNames() {
        Vector<String> locationsNamesList = new Vector<>();
        locationsNamesList.add(vegDptLocation.getLocationLabel());
        locationsNamesList.add(theDoorLocation.getLocationLabel());
        return locationsNamesList;
    }

    private void addToGamePane() {

        gamePane.add(locationSwitcher.getSwitcherContainer(), BorderLayout.PAGE_START);
        gamePane.add(locationsHolder, BorderLayout.CENTER);
    }

    JPanel getLocationsHolder() {
        return locationsHolder;
    }

    public JPanel getGamePane() {
        return gamePane;
    }
}
