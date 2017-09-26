package timer;

public class Seconds implements TimeUnit {
    private int secondsValue;
    static final int MAX_VALUE = 59;
    public Seconds(){
        secondsValue=0;
    }
    public void setToZero(){
        secondsValue = 0;
    }
    @Override
    public void increment() {
        secondsValue++;
    }

    @Override
    public int getValue() {
        return secondsValue;
    }

    @Override
    public boolean checkMaxValue() {
        return secondsValue == MAX_VALUE;
    }
}
