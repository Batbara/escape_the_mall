package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class TimerAction implements ActionListener {
    TimerView timerView;
    public TimerAction(TimerView timerView){
        this.timerView = timerView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timerView.timePassed();
    }
}
