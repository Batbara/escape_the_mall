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

        GameScreen gameScreen = new GameScreen();
        mainFrame.setGameScreen(gameScreen);
        JFrame frame = mainFrame.getFrame();
        frame.getContentPane().removeAll();
        frame.add(gameScreen.getGameScreen());
        frame.revalidate();
        frame.repaint();
    }
    private void showStarterScreen(){
        JFrame frame = mainFrame.getFrame();
        frame.getContentPane().removeAll();

        StarterScreen starterScreen = new StarterScreen();
        mainFrame.setStarterScreen(starterScreen);
        mainFrame.addStarterButtonsListeners();

        frame.add(starterScreen.getScreen());
        frame.revalidate();
        frame.repaint();
    }
    private void showGameOverScreen(){
        JComponent gameOverScreen = mainFrame.getGameOverScreen().getGameOverScreen();
        JFrame frame = mainFrame.getFrame();
        frame.getContentPane().removeAll();
        frame.add(gameOverScreen);
        frame.revalidate();
        frame.repaint();
    }
    private void startTimer(){
        StatusBar statusBar = mainFrame.getGameScreen().getStatusBar();

        Timer timer = statusBar.getTimer();
        timer.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        mainFrame = (MainFrame)o;
        String screen = (String)arg;
        switch (screen){
            case "starter":
                showStarterScreen();
                break;
            case "game":
                showGameScreen();
                startTimer();
                break;
            case "gameover":
                showGameOverScreen();
                break;
        }
    }
}
