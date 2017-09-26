package timer;

public interface TimeUnit {
    int MAX_VALUE = 59;

    void increment();

    int getValue();

    boolean checkMaxValue();
}
