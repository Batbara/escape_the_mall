package frames;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class GameOverScreenPresenter implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        MainFrame.getInstance().showStarterScreen();
    }

}
