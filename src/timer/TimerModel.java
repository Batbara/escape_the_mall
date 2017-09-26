package timer;

public class TimerModel {
    private Minutes minutes;
    private Seconds seconds;

    public TimerModel() {
        minutes = new Minutes();
        seconds = new Seconds();
    }

    public void increaseTime() {
        if (seconds.checkMaxValue()) {
            seconds.setToZero();
            if(minutes.checkMaxValue()){
                //TODO throw exception timer overflow
            }
            else minutes.increment();
        }
        else seconds.increment();
    }


    public String getTimeUnitInString(TimeUnit timeUnit){
        int value = timeUnit.getValue();
        if(value == 0){
            return "00";
        }
        String stringValue = Integer.toString(value);
        if(value / 10==0){
            return "0"+stringValue;
        }
        return stringValue;
    }
    public Minutes getMinutes() {
        return minutes;
    }

    public Seconds getSeconds() {
        return seconds;
    }
}
