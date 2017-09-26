package timer;

public class Minutes implements TimeUnit{
    int minutesValue;
    static final int MAX_VALUE = 59;
    public Minutes(){
        minutesValue = 0;
    }

    @Override
    public void increment() {
        minutesValue++;
    }

    @Override
    public int getValue() {
        return minutesValue;
    }

    @Override
    public boolean checkMaxValue() {
        return minutesValue == MAX_VALUE;
    }
}
