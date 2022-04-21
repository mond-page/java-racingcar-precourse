package racingcar.model;

public class Position {
    private static final int START_POSITION_VALUE = 0;

    private int value;

    private Position() {
        value = START_POSITION_VALUE;
    }

    public static Position create() {
        return new Position();
    }

    public void moveValue() {
        this.value++;
    }

    public int getValue() {
        return value;
    }
}
