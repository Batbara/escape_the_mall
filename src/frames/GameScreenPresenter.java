package frames;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class GameScreenPresenter implements Observer {
    Observable observable;

    private void resumeTimer(){
        GameScreen gameScreen = (GameScreen)observable;
        Timer timer = gameScreen.getStatusBar().getTimer();
        timer.start();
    }
    @Override
    public void update(Observable o, Object arg) {
        observable = o;
        GameScreen gameScreen = (GameScreen)observable;
        Timer timer = gameScreen.getStatusBar().getTimer();
        String action = (String)arg;
        switch (action){
            case "pause":
                timer.stop();
                break;
            case "resume":
                timer.start();
                break;
        }
    }
}
