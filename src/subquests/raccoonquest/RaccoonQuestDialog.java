package subquests.raccoonquest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class RaccoonQuestDialog extends Observable{
    private JDialog dialogFrame;
    private List<JButton> answerButtons;
    private JTextArea questionPane;
    private JFrame ownerFrame;
    public RaccoonQuestDialog(JFrame owner){
        dialogFrame = new JDialog(owner,"Квест", Dialog.ModalityType.DOCUMENT_MODAL);
        this.ownerFrame = owner;
        initDialogWindow();
        initQuestionPane();
        initAnswerButtons();
        placeComponentsOnWindow();
        addObserver(new RaccoonQuestPresenter(new RaccoonQuestModel(),this));
    }
    private void initDialogWindow(){
        final int DIALOG_WIDTH = 250;
        final int DIALOG_HEIGHT = 350;

        dialogFrame.setSize(new Dimension(DIALOG_WIDTH,DIALOG_HEIGHT));
        dialogFrame.setPreferredSize(new Dimension(DIALOG_WIDTH, DIALOG_HEIGHT));
        dialogFrame.setMaximumSize(new Dimension(DIALOG_WIDTH, DIALOG_HEIGHT));
        dialogFrame.setLayout(new GridLayout(2,1));
        dialogFrame.pack();
        dialogFrame.setResizable(false);
        centerOnScreen();
    }
    private void initQuestionPane(){
        questionPane = new JTextArea();
        questionPane.setSize(new Dimension(250,150));
        questionPane.setPreferredSize(questionPane.getSize());
        questionPane.setMaximumSize(questionPane.getPreferredSize());
        questionPane.setEditable(false);
        questionPane.setLineWrap(true);
        questionPane.setWrapStyleWord(true);
        questionPane.setBackground(Color.decode("#E9FAFD"));
        questionPane.setBorder(BorderFactory.createLoweredBevelBorder());
        questionPane.setText("Вы тянетесь за пакетиком с лимонами, но вдруг слышите странный звук позади себя. Что сделать?");
        questionPane.setFont(new Font("Helvetica", Font.PLAIN, 20));
    }
    private void initAnswerButtons(){
        answerButtons = new ArrayList<>();
        String[] buttonsNames = {"Смело оглянуться","Замереть на полпути к пакетику","<html><center>Бежать сломя голову<br>неизвестно куда</center>"};
        for(String buttonName : buttonsNames){
            JButton button = new JButton(buttonName);
            button.setActionCommand(buttonName);
            button.setSize(new Dimension(dialogFrame.getWidth(),80));
            button.setPreferredSize(button.getSize());

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    questionAnswered(button.getActionCommand());
                    System.out.println("нажата кнопка "+button.getActionCommand());
                }
            });

            answerButtons.add(button);
       }
    }
    private JPanel getButtonsHolder(){
        JPanel buttonsHolder = new JPanel(new GridLayout(3,1));

        for(JButton button : answerButtons){
            buttonsHolder.add(button);
        }
        return buttonsHolder;
    }
    private void placeComponentsOnWindow(){
        dialogFrame.add(questionPane);
        dialogFrame.add(getButtonsHolder());
    }
    private void centerOnScreen() {
        final int width = dialogFrame.getWidth();
        final int height = dialogFrame.getHeight();
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (width / 2);
        int y = (screenSize.height / 2) - (height / 2);

        dialogFrame.setLocation(x, y);
    }

    private void questionAnswered(String buttonName){
        setChanged();
        notifyObservers(buttonName);
    }

    public JDialog getDialogFrame() {
        return dialogFrame;
    }

    public JTextArea getQuestionPane() {
        return questionPane;
    }

    public List<JButton> getAnswerButtons() {
        return answerButtons;
    }

    public JFrame getOwnerFrame() {
        return ownerFrame;
    }
}
