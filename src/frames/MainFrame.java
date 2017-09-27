package frames;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;


public class MainFrame extends Observable{
    private JFrame frame;
    private StarterScreen starterScreen;
    private GameScreen gameScreen;

    public MainFrame() throws IOException {
        initFrame();
        initScreens();

        MainFramePresenter framePresenter = new MainFramePresenter(this);
        starterScreen.addButtonsListeners(this);


        frame.add(starterScreen.getScreen());
        addObserver(framePresenter);
    }

    private void initFrame() throws IOException {
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
        notifyObservers();
    }
}
