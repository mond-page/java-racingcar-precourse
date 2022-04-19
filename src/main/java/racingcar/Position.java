package racingcar;

public class Position {
    private static final int MOVING_MIN_NUMBER = 4;
    private static final int MOVING_MAX_NUMBER = 9;

    public static boolean isMoving(int number) {
        return number >= MOVING_MIN_NUMBER && number <= MOVING_MAX_NUMBER;
    }
}
