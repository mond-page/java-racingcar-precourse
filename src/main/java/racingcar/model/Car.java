package racingcar.model;

import racingcar.constants.CarMessage;

public class Car {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MOVING_MIN_NUMBER = 4;

    private final Position position;

    private Car() {
        this.position = Position.create();
    }

    public static Car create() {
        return new Car();
    }

    public void move(int number) {
        validateNumberRange(number);
        if (isMoving(number)) {
            position.movePosition();
        }
    }

    boolean isMoving(int number) {
        return number >= MOVING_MIN_NUMBER;
    }

    void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(CarMessage.INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    public int getPosition() {
        return position.getPosition();
    }
}
