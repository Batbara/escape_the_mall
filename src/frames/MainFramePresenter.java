package frames;

import frames.GameScreen;
import frames.MainFrame;
import frames.StarterScreen;

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
    }
}
