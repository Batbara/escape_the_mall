package locations;

import locations.vegetable.VegetableDepartmentLocation;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class LocationManager {
    private JPanel gamePane;
    private JPanel scenesHolder;
    private LocationSwitcher locationSwitcher;
    private VegetableDepartmentLocation vegDptLocation;
    public LocationManager(){
        initMainPanel();
        initLocations();
        initScenesHolder();

        Vector<String> locationsNamesList = new Vector<>();
        locationsNamesList.add(vegDptLocation.getLocationLabel());
        locationSwitcher = new LocationSwitcher(locationsNamesList);
        locationSwitcher.assignListener(this);
        addToGamePane();
    }
    private void initMainPanel(){
        gamePane = new JPanel(new BorderLayout());
    }
    private void initLocations(){
        vegDptLocation = new VegetableDepartmentLocation();
    }
    private void initScenesHolder(){
         scenesHolder = new JPanel(new CardLayout());
        //scenesHolder = place all locations on this panel
        scenesHolder.add(vegDptLocation.getContainer(),vegDptLocation.getLocationLabel());
    }
    private void addToGamePane(){

        gamePane.add(locationSwitcher.getSwitcherContainer(),BorderLayout.PAGE_START);
        gamePane.add(scenesHolder,BorderLayout.CENTER);
    }

    public JPanel getScenesHolder() {
        return scenesHolder;
    }

    public JPanel getGamePane() {
        return gamePane;
    }
}
