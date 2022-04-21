package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(Names names) {
        cars = new ArrayList<>();
        for (Name name : names.getNames()) {
            cars.add(Car.create(name));
        }
    }

    public static Cars create(Names names) {
        return new Cars(names);
    }

    public void move() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
