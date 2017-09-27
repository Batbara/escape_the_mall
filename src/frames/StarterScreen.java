package frames;

import commongui.PanelWithImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StarterScreen {
    private PanelWithImage screen;
    private Map<String, JButton> optionButtons;


    public StarterScreen() {
        try {
            initScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initButtons();
        placeButtonsOnScreen();
    }

    private void initScreen() throws IOException {
        Image background = ImageIO.read(new File(this.getClass().getResource("/frames/img/background.png").getPath()));
        screen = new PanelWithImage(background);
        screen.setLayout(new BorderLayout());

    }

    private void initButtons() {
        optionButtons = new HashMap<>();
        String[] buttonKeys = {"play", "leaderboard", "settings", "help"};
        String[] tipText = {"Начать игру", "Рекорды", "Настройки", "Помощь"};
        Map<String, String> tipTextMap = new HashMap<>();
        for (int index = 0; index < buttonKeys.length; index++) {
            tipTextMap.put(buttonKeys[index], tipText[index]);
        }
        for (String key : buttonKeys) {
            String text = tipTextMap.get(key);
            optionButtons.put(key, createButton(key, key + "pressed", text));
        }
    }

    private JButton createButton(String fileName, String pressedFileName,
                                 String tipText) {

        String mainImgLocation = "/frames/img/" + fileName + ".png";
        String pressedImgLocation = "/frames/img/" + pressedFileName + ".png";

        ImageIcon image = new ImageIcon(this.getClass().getResource(mainImgLocation));
        ImageIcon pressedImage = new ImageIcon(this.getClass().getResource(pressedImgLocation));


        JButton button = new JButton();
        button.setIcon(image);
        button.setBorder(null);
        button.setBackground(null);
        button.setContentAreaFilled(false);
        button.setToolTipText(tipText);

        button.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isPressed())
                button.setIcon(pressedImage);
            else
                button.setIcon(image);


        });

        return button;
    }

    private void placeButtonsOnScreen() {

        GridBagConstraints constraint = new GridBagConstraints();
        screen.setLayout(new GridBagLayout());

        constraint.gridx = 2;
        constraint.gridy = 0;
        //  constraint.weighty=1.2;
        constraint.anchor = GridBagConstraints.CENTER;
        constraint.ipady = 345;
        //  constraint.gridwidth = GridBagConstraints.CENTER;

        screen.add(optionButtons.get("play"), constraint);

        int xShift = 0;
        for (String key : optionButtons.keySet()) {
            constraint.gridx = xShift++;
            constraint.weighty = 0.8;

            constraint.anchor = GridBagConstraints.PAGE_END;
            constraint.ipadx = 1;
            constraint.gridy = 5;
            if (key.equals("play"))
                continue;
            screen.add(optionButtons.get(key), constraint);
        }
    }

    public void addButtonsListeners(MainFrame mainFrame){
        JButton playButton = optionButtons.get("play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showGameScreen();
            }
        });
    }
    public PanelWithImage getScreen() {
        return screen;
    }
}
