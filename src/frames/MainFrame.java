package frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainFrame {
    private JFrame frame;
   // private JPanel backroundPanel;
    private StarterScreen starterScreen;

    public MainFrame() throws IOException {
    initFrame();
    starterScreen = new StarterScreen();
    frame.add(starterScreen.getScreen());
    }
    private void initFrame() throws IOException {
        frame = new JFrame("Escape the Mall");
        frame.setLayout(new BorderLayout());
//        Image background = ImageIO.read(new File(this.getClass().getResource("/img/background.png").getPath()));
//        frame.setContentPane(new BackgroundImage(background));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(1200,700));
        frame.setSize(frame.getPreferredSize());
        frame.setResizable(false);
    }
    private void initBackroundPanel(){

    }
}
