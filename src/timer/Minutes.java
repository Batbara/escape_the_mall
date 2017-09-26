package timer;

public class Minutes implements TimeUnit {
    private int minutesValue;

    Minutes() {
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
        return minutesValue == TimeUnit.MAX_VALUE;
    }
}
