package frames;

import frames.GameScreen;
import frames.MainFrame;
import frames.StarterScreen;
import status.StatusBar;

import javax.swing.*;

public class MainFramePresenter {
    private MainFrame mainFrame;
    public MainFramePresenter(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    public void showGameScreen(){
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
}
