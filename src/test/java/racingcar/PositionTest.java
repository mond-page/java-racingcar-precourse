package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("4이상 9이하의 수이면 전진할 수 있다")
    void canMove() {
        assertAll(
                () -> assertThat(Position.isMoving(4)).isTrue(),
                () -> assertThat(Position.isMoving(9)).isTrue()
        );
    }

    @Test
    @DisplayName("0이상 3이하의 수이면 전진할 수 없다")
    void canNotMove() {
        assertAll(
                () -> assertThat(Position.isMoving(3)).isFalse(),
                () -> assertThat(Position.isMoving(0)).isFalse()
        );
    }
}
