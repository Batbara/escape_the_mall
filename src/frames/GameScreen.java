package frames;

import inventory.InventoryView;
import scenes.LocationManager;

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
       // mainScene = new GameScene();
        locationManager = new LocationManager();
    }
    private void placeComponents(){
        gameScreen.setLayout(new BorderLayout());
        gameScreen.add(statusBar.getStatusBarPanel(),BorderLayout.PAGE_END);
        gameScreen.add(inventoryView.getInventoryPanel(),BorderLayout.EAST);
        gameScreen.add(locationManager.getGamePane(),BorderLayout.WEST);
    }

    public JPanel getGameScreen() {
        return gameScreen;
    }
}
