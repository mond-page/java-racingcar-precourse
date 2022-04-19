package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.PositionMessage;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = Position.create();
    }

    @ParameterizedTest(name = "4이상 9이하의 수({0})이면 전진할 수 있다")
    @ValueSource(ints = {4, 9})
    void canMove(int number) {
        assertThat(position.isMoving(number)).isTrue();
    }

    @ParameterizedTest(name = "0이상 3이하의 수({0})이면 전진할 수 없다")
    @ValueSource(ints = {0, 3})
    void canNotMove(int number) {
        assertThat(position.isMoving(number)).isFalse();
    }

    @ParameterizedTest(name = "0보다 작거나 9보다 큰 수({0})는 잘못된 값이다")
    @ValueSource(ints = {-1, 10})
    void invalidNumber(int number) {
        assertThatThrownBy(() -> position.validateNumberRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PositionMessage.INVALID_NUMBER_RANGE_MESSAGE);
    }

    @ParameterizedTest(name = "전진이 가능(입력받은 수 : {0})하다면 1만큼 움직인다")
    @ValueSource(ints = {4, 9})
    void isMovingTrueThenMoveStep(int number) {
        position.moveStep(number);
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest(name = "전진이 불가능(입력받은 수 : {0})하다면 움직이지 않는다")
    @ValueSource(ints = {0, 3})
    void isMovingFalseThenDontMoveStep(int number) {
        position.moveStep(number);
        assertThat(position.getPosition()).isZero();
    }
}
