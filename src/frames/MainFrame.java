package frames;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class MainFrame {
    private JFrame frame;
    private StarterScreen starterScreen;
    private GameScreen gameScreen;
    private MainFramePresenter framePresenter;

    public MainFrame() throws IOException {
        initFrame();
        framePresenter = new MainFramePresenter(this);
        starterScreen = new StarterScreen();
        starterScreen.addButtonsListeners(new StartButtonListener(framePresenter));
        gameScreen = new GameScreen();

        frame.add(starterScreen.getScreen());
        //frame.add(gameScreen.getGameScreen());
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

    public StarterScreen getStarterScreen() {
        return starterScreen;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }



    public JFrame getFrame() {
        return frame;
    }
}
