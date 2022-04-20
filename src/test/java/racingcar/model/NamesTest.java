package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.NameMessage;

class NamesTest {

    @ParameterizedTest(name = "5자 이하의 이름으로 2개 이상의 값({0})을 입력 받는다")
    @ValueSource(strings = {"mond,latte,bana", "apple, pink, choco"})
    void inputValidNames(String inputNames) {
        assertThat(new Names(inputNames)).isNotNull();
    }

    @Test
    @DisplayName("구분자만 입력 받는다")
    void inputInvalidNamesOnlySeparatorCharacter() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Names(","))
                .withMessageContaining(NameMessage.EMPTY_INPUT_NAMES);
    }

    @Test
    @DisplayName("공백을 입력 받는다")
    void inputInvalidNamesOnlyEmptyString() {
        assertThatThrownBy(() -> new Names(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NameMessage.INVALID_NAME_LENGTH);
    }

    @Test
    @DisplayName("중복된 이름이 존재한다.")
    void inputInvalidNamesDuplicateName() {
        assertThatThrownBy(() -> new Names("mond,choco,mond"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NameMessage.DUPLICATE_INPUT_NAME);
    }
}
