package subquests.racoonquest;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RaccoonQuestDialog extends JDialog{
    private List<JButton> answerButtons;
    private JTextPane questionPane;
    public RaccoonQuestDialog(JFrame owner){
        super(owner,"Квееееест", ModalityType.DOCUMENT_MODAL);
        initDialogWindow();
        initQuestionPane();
        initAnswerButtons();
        placeComponentsOnWindow();
    }
    private void initDialogWindow(){
        final int DIALOG_WIDTH = 250;
        final int DIALOG_HEIGHT = 350;

        this.setSize(new Dimension(DIALOG_WIDTH,DIALOG_HEIGHT));
        this.setPreferredSize(new Dimension(DIALOG_WIDTH, DIALOG_HEIGHT));
        this.setMaximumSize(new Dimension(DIALOG_WIDTH, DIALOG_HEIGHT));
        this.setLayout(new GridLayout(2,1));
        this.pack();
        this.setResizable(false);
        centerOnScreen();
    }
    private void initQuestionPane(){
        questionPane = new JTextPane();
        questionPane.setSize(new Dimension(250,150));
        questionPane.setPreferredSize(questionPane.getSize());
        questionPane.setEditable(false);
        questionPane.setBackground(Color.decode("#E9FAFD"));
        questionPane.setBorder(BorderFactory.createLoweredBevelBorder());

        questionPane.setFont(new Font("Helvetica", Font.PLAIN, 19));
    }
    private void initAnswerButtons(){
        answerButtons = new ArrayList<>();
        int buttonsNumber = 3;
        for(int count = 0; count<buttonsNumber; count++){
            JButton button = new JButton("button "+(count+1));
            button.setSize(new Dimension(this.getWidth(),40));
            answerButtons.add(new JButton("button "+(count+1)));
       }
        /*answerButtons.add(new JButton("lol"));
        answerButtons.add(new JButton("kek"));
        answerButtons.add(new JButton("cheburek"));*/
    }
    private JPanel getButtonsHolder(){
        JPanel buttonsHolder = new JPanel(new GridLayout(3,1));
       // buttonsHolder.setLayout(new BoxLayout(buttonsHolder,BoxLayout.Y_AXIS));

        for(JButton button : answerButtons){
            buttonsHolder.add(button);
        }
        return buttonsHolder;
    }
    private void placeComponentsOnWindow(){
        this.add(questionPane);
        this.add(getButtonsHolder());
    }
    public void centerOnScreen() {
        final int width = this.getWidth();
        final int height = this.getHeight();
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (width / 2);
        int y = (screenSize.height / 2) - (height / 2);

        this.setLocation(x, y);
    }
}
