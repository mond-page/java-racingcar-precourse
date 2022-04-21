package racingcar.model;

public class Position {
    private static final int START_POSITION_VALUE = 0;

    private int value;

    private Position() {
        value = START_POSITION_VALUE;
    }

    private Position(int value) {
        this.value = value;
    }

    public static Position create() {
        return new Position();
    }

    public static Position valueOf(int value) {
        return new Position(value);
    }

    public void moveValue() {
        this.value++;
    }

    public int getValue() {
        return value;
    }

    public Position getMorePosition(Position position) {
        if (this.value - position.getValue() > 0) {
            return this;
        }

        return position;
    }
}
