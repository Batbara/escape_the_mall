package frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class StarterScreen {
    private BackgroundImage screen;
    private JButton startGameButton;
    private JButton aboutButton;
    private  JButton settingsButton;

    public StarterScreen(){
        try {
            initScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        startGameButton = initButton("playbutton","playbutton",
                "playbutton","Начать игру");
        screen.add(startGameButton,BorderLayout.CENTER);
    }
    private void initScreen() throws IOException {
        Image background = ImageIO.read(new File(this.getClass().getResource("/img/background.png").getPath()));
        screen = new BackgroundImage(background);
        screen.setLayout(new BorderLayout());

    }
    private JButton initButton (String fileName, String hoverFileName, String pressedFileName,
                                String tipText){

        String mainImgLocation = "/img/"+fileName+".png";
        String hoverImgLocation = "/img/"+hoverFileName+".png";
        String pressedImgLocation = "/img/"+pressedFileName+".png";

        ImageIcon image = new ImageIcon(this.getClass().getResource(mainImgLocation));
        ImageIcon hoverImage = new ImageIcon(this.getClass().getResource(hoverImgLocation));
        ImageIcon pressedImage = new ImageIcon(this.getClass().getResource(pressedImgLocation));


        JButton button = new JButton();
        button.setIcon(image);
        button.setBorder(null);
        // button.setMargin(new Insets(0, 0, 0, 0));
        button.setBackground(null);
        button.setContentAreaFilled(false);
        button.setToolTipText(tipText);

        button.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isRollover()) {
                button.setIcon(hoverImage);
            } else {
                button.setIcon(image);
            }
            if (model.isPressed())
                button.setIcon(pressedImage);
        });

        return button;
    }

    public BackgroundImage getScreen() {
        return screen;
    }
}
