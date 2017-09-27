package timer;


import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class TimerPresenter implements Observer {
    private Observable observable;
    private TimerModel timerModel;

    public TimerPresenter(Observable observable, TimerModel timerModel) {
        this.observable = observable;
        this.timerModel = timerModel;
    }

    private void repaintTimer() {
        TimerView timerView = (TimerView) observable;
        JLabel minutesLabel = timerView.getMinutesLabel();
        JLabel secondsLabel = timerView.getSecondsLabel();

        Minutes timeMinutes = timerModel.getMinutes();
        Seconds timeSeconds = timerModel.getSeconds();

        secondsLabel.setText(timerModel.getTimeUnitInString(timeSeconds));
        minutesLabel.setText(timerModel.getTimeUnitInString(timeMinutes));
    }
    private void stopTimer(){
        TimerView timerView = (TimerView) observable;
       // Timer timer = timerView.g
    }

    @Override
    public void update(Observable o, Object arg) {
        observable = o;
        if(arg instanceof Boolean){

        } else {
            timerModel.increaseTime();
            repaintTimer();
        }
    }
}
