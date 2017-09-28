package frames;

import commongui.PanelWithImage;
import commongui.Tools;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Observable;

public class GameOverScreen extends Observable{
    private PanelWithImage gameOverScreen;
    public GameOverScreen(){
        initGameOverScreen();
        gameOverScreen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeScreen();
            }
        });
        addObserver(new GameOverScreenPresenter());
    }
    private void initGameOverScreen(){
        try {
            gameOverScreen = Tools.getInstance().createPanel("/frames/img/gameover");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void changeScreen(){
        setChanged();
        notifyObservers();
    }

    public PanelWithImage getGameOverScreen() {
        return gameOverScreen;
    }

}
