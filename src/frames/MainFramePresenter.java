package frames;

import status.StatusBar;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class MainFramePresenter implements Observer{
    private MainFrame mainFrame;
    public MainFramePresenter(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    private void showGameScreen(){
        JPanel gameScreen = mainFrame.getGameScreen().getGameScreen();
        JComponent starterScreen = mainFrame.getStarterScreen().getScreen();
        JFrame frame = mainFrame.getFrame();
        frame.remove(starterScreen);
        frame.add(gameScreen);
        frame.revalidate();
        frame.repaint();
        startTimer();
    }
    private void startTimer(){
        StatusBar statusBar = mainFrame.getGameScreen().getStatusBar();

        Timer timer = statusBar.getTimer();
        timer.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        mainFrame = (MainFrame)o;
        showGameScreen();
        startTimer();
    }
}
