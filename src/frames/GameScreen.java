package frames;

import inventory.InventoryView;
import locations.LocationManager;
import status.StatusBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;


class GameScreen extends Observable {
    private StatusBar statusBar;
    private InventoryView inventoryView;
    private LocationManager locationManager;
    private JPanel gameScreen;

    GameScreen() {
        initComponents();
        gameScreen = new JPanel();
        placeComponents();
        addKeyBinder();
        addObserver(new GameScreenPresenter());
    }

    private void addKeyBinder() {
        gameScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "pause");

        Action pauseTimer = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseTimer();
                JOptionPane.showMessageDialog(gameScreen,
                        "Игра на паузе",
                        "Пауза",
                        JOptionPane.INFORMATION_MESSAGE);
                resumeTimer();
            }
        };
        gameScreen.requestFocus();
        gameScreen.getActionMap().put("pause", pauseTimer);

    }

    private void resumeTimer() {
        setChanged();
        notifyObservers("resume");
    }

    private void pauseTimer() {

        setChanged();
        notifyObservers("pause");
    }

    private void initComponents() {
        statusBar = new StatusBar();
        inventoryView = new InventoryView();
        locationManager = new LocationManager();
    }

    private void placeComponents() {
        gameScreen.setLayout(new BorderLayout());
        gameScreen.add(statusBar.getStatusBarPanel(), BorderLayout.PAGE_END);
        JPanel inventoryHolder = new JPanel();
        inventoryHolder.setLayout(new BoxLayout(inventoryHolder, BoxLayout.Y_AXIS));

        inventoryHolder.add(Box.createRigidArea(new Dimension(inventoryHolder.getWidth(), 40)));
        inventoryHolder.add(inventoryView.getInventoryPanel());
        gameScreen.add(inventoryHolder, BorderLayout.EAST);
        gameScreen.add(locationManager.getGamePane(), BorderLayout.WEST);
    }

    JPanel getGameScreen() {
        return gameScreen;
    }

    StatusBar getStatusBar() {
        return statusBar;
    }
}
