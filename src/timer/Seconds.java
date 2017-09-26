package timer;

public class Seconds implements TimeUnit {
    private int secondsValue;
    Seconds(){
        secondsValue=0;
    }
    void setToZero(){
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
        return secondsValue == TimeUnit.MAX_VALUE;
    }
}
