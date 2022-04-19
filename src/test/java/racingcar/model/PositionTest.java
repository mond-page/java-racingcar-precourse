package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constants.PositionMessage;

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

    @Test
    @DisplayName("0보다 작거나 9보다 큰 수는 잘못된 값이다")
    void invalidNumber() {
        assertAll(
                () -> assertThatThrownBy(() -> Position.validateNumberRange(10))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(PositionMessage.INVALID_NUMBER_RANGE_MESSAGE),
                () -> assertThatThrownBy(() -> Position.validateNumberRange(-1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(PositionMessage.INVALID_NUMBER_RANGE_MESSAGE)
        );
    }
}
