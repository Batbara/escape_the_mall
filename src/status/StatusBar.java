package status;

import timer.TimerAction;
import timer.TimerModel;
import timer.TimerPresenter;
import timer.TimerView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StatusBar {
    private JPanel statusBarPanel;
    private TimerView timerView;
    private Timer timer;
    public StatusBar() {
       initStatusBarPanel();
       initTimerView();
       timer = new Timer(1000,new TimerAction(timerView));
       addTimerViewToBar();
    }
    private void initStatusBarPanel(){
        statusBarPanel = new JPanel();
        statusBarPanel.setLayout(null);
        statusBarPanel.setSize(new Dimension(500, 50));
        statusBarPanel.setPreferredSize(statusBarPanel.getSize());
    }
    private void initTimerView(){
        timerView = new TimerView();
        timerView.addObservingPresenter(new TimerPresenter(timerView,new TimerModel()));
    }
    public JPanel getStatusBarPanel() {
        return statusBarPanel;
    }
    private void addTimerViewToBar(){
       JPanel timerPanel = timerView.getTimerContainer();
        statusBarPanel.add(timerPanel);
        timerPanel.setBounds(930,0,timerPanel.getWidth(),timerPanel.getHeight());
    }
    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
