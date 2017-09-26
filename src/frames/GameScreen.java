package frames;

import inventory.InventoryView;
import locations.LocationManager;
import status.StatusBar;

import javax.swing.*;
import java.awt.*;


public class GameScreen {
    private StatusBar statusBar;
    private InventoryView inventoryView;
    //private GameScene mainScene;
    private LocationManager locationManager;
    private JPanel gameScreen;

    public GameScreen(){
        initComponents();
        gameScreen = new JPanel();
        placeComponents();
    }
    private void initComponents(){
        statusBar = new StatusBar();
        inventoryView = new InventoryView();
        locationManager = new LocationManager();
    }
    private void placeComponents(){
        gameScreen.setLayout(new BorderLayout());
        gameScreen.add(statusBar.getStatusBarPanel(),BorderLayout.PAGE_END);
        JPanel inventoryHolder = new JPanel();
        inventoryHolder.setLayout(new BoxLayout(inventoryHolder,BoxLayout.Y_AXIS));

        inventoryHolder.add(Box.createRigidArea(new Dimension(inventoryHolder.getWidth(),40)));
        inventoryHolder.add(inventoryView.getInventoryPanel());
        gameScreen.add(inventoryHolder,BorderLayout.EAST);
        gameScreen.add(locationManager.getGamePane(),BorderLayout.WEST);
    }

    public JPanel getGameScreen() {
        return gameScreen;
    }

    public StatusBar getStatusBar() {
        return statusBar;
    }
}
