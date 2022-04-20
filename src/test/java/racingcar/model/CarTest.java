package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.create();
    }

    @Test
    @DisplayName("전진 가능한 값이면 움직일 수 있다")
    void isMovingTrueThenMoveCar() {
        car.move(5);
        assertThat(car.getPosition()).isPositive();
    }

    @Test
    @DisplayName("전진 가능한 값이 아니면 움직일 수 없다")
    void isMovingFalseThenDontMoveCar() {
        car.move(3);
        assertThat(car.getPosition()).isZero();
    }
}
