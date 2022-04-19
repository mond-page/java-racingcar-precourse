package racingcar.model;

import racingcar.constants.PositionMessage;

public class Position {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MOVING_MIN_NUMBER = 4;

    public static boolean isMoving(int number) {
        validateNumberRange(number);
        return number >= MOVING_MIN_NUMBER;
    }

    static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(PositionMessage.INVALID_NUMBER_RANGE_MESSAGE);
        }
    }
}
