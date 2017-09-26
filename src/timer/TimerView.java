package timer;

import frames.PanelWithImage;
import frames.Tools;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;

public class TimerView extends Observable{
    private PanelWithImage timerIcon;
    private JLabel minutesLabel;
    private JLabel secondsLabel;
    private JPanel timerContainer;
    public TimerView(){
        initTimerIcon();
        initLabels();
        initTimerContainer();
        addToContainer();
    }
    private void initTimerIcon(){
        try {
            timerIcon = Tools.getInstance().createPanel("/timer/img/ticon");
            System.out.println("shit");
            timerIcon.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void initLabels(){
        minutesLabel = new JLabel("00");
        minutesLabel.setOpaque(true);
        setLabelSize(minutesLabel);

        secondsLabel = new JLabel("00");
        secondsLabel.setOpaque(true);
        setLabelSize(secondsLabel);
    }
    private void initTimerContainer(){
        timerContainer = new JPanel();
        timerContainer.setLayout(new BoxLayout(timerContainer,BoxLayout.LINE_AXIS));
        timerContainer.setSize(new Dimension(170,60));
        timerContainer.setPreferredSize(timerContainer.getSize());
        timerContainer.setOpaque(true);

    }
    private void addToContainer(){
        timerContainer.add(timerIcon);

        JPanel labelPanel = new JPanel(new FlowLayout());
        labelPanel.add(minutesLabel);

        JLabel columnLabel = new JLabel(" : ");
        setLabelSize(columnLabel);

        labelPanel.add(columnLabel);
        labelPanel.add(secondsLabel);

        timerContainer.add(labelPanel);

    }
    private void setLabelSize(JLabel label){
        label.setFont(new Font("Serif", Font.BOLD, 20));
//        label.setSize(new Dimension(15,15));
//        label.setPreferredSize(minutesLabel.getSize());
    }
    public void timePassed(){
        setChanged();
        notifyObservers();
    }

    public JLabel getMinutesLabel() {
        return minutesLabel;
    }

    public JLabel getSecondsLabel() {
        return secondsLabel;
    }

    public void addObservingPresenter(TimerPresenter presenter) {
        addObserver(presenter);
    }

    public JPanel getTimerContainer() {

        return timerContainer;
    }
}
