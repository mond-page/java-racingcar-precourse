package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차들의 이름을 설정해준다")
    void setCarNames() {
        Cars cars = Cars.create(Names.valueOf("mond,latte,bana"));
        Assertions.assertThat(cars.getCars()).hasSize(3);
    }
}
