package racingcar.model;

import racingcar.constants.PositionMessage;

public class Position {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MOVING_MIN_NUMBER = 4;
    private static final int START_POSITION_VALUE = 0;

    private int value;

    private Position() {
        value = START_POSITION_VALUE;
    }

    public static Position create() {
        return new Position();
    }

    public void moveStep(int number) {
        if (isMoving(number)) {
            this.value += 1;
        }
    }

    boolean isMoving(int number) {
        validateNumberRange(number);
        return number >= MOVING_MIN_NUMBER;
    }

    void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(PositionMessage.INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    public int getPosition() {
        return value;
    }
}
