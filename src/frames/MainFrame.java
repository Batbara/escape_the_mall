package frames;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;


public class MainFrame extends Observable{
    private static final MainFrame instance = new MainFrame();
    private JFrame frame;
    private StarterScreen starterScreen;
    private GameScreen gameScreen;
    private GameOverScreen gameOverScreen;
    public static MainFrame getInstance(){
        return instance;
    }
    private MainFrame()  {
        initFrame();
        initScreens();

        MainFramePresenter framePresenter = new MainFramePresenter(this);
        addStarterButtonsListeners();

        frame.add(starterScreen.getScreen());
        addObserver(framePresenter);
    }
    public void addStarterButtonsListeners(){

        starterScreen.addButtonsListeners(this);
    }
    private void initFrame(){
        frame = new JFrame("Escape the Mall");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(1150, 655));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(frame.getPreferredSize());
        frame.setResizable(false);
    }
    private void initScreens(){
        starterScreen = new StarterScreen();
        gameScreen = new GameScreen();
        gameOverScreen = new GameOverScreen();
    }

    StarterScreen getStarterScreen() {
        return starterScreen;
    }

    GameScreen getGameScreen() {
        return gameScreen;
    }

    JFrame getFrame() {
        return frame;
    }
    public void showGameScreen(){
        JOptionPane.showMessageDialog(frame,
                "Вам предстоит найти выход из закрытого супермаркета. Покажите минимальное время и попадите в таблицу рекордов!",
                "Побег из супермаркета",
                JOptionPane.INFORMATION_MESSAGE);
        setChanged();
        notifyObservers("game");
    }
    public void showStarterScreen(){
        setChanged();
        notifyObservers("starter");
    }
    public void showGameOverScreen(){
        setChanged();
        notifyObservers("gameover");
    }

    public GameOverScreen getGameOverScreen() {
        return gameOverScreen;
    }

    public void setStarterScreen(StarterScreen starterScreen) {
        this.starterScreen = starterScreen;
    }

    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }
}
