package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = Position.create();
    }

    @Test
    @DisplayName("초기 위치는 0이다.")
    void initPositionZero() {
        assertThat(position.getValue()).isZero();
    }

    @Test
    @DisplayName("움직이면 위치는 1만큼 증가한다.")
    void movePositionThen() {
        position.moveValue();

        assertAll(
                () -> assertThat(position.getValue()).isNotZero(),
                () -> assertThat(position.getValue()).isEqualTo(1)
        );
    }
}
