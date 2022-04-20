package racingcar.model;

public class Car {
    private final Position position;

    private Car() {
        this.position = Position.create();
    }

    public static Car create() {
        return new Car();
    }

    public void move(int number) {
        position.moveStep(number);
    }

    public int getPosition() {
        return position.getPosition();
    }
}
