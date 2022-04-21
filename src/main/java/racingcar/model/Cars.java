package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    private Cars(Names names) {
        cars = new ArrayList<>();
        for (Name name : names.getNames()) {
            cars.add(Car.create(name));
        }
    }

    public static Cars create(Names names) {
        return new Cars(names);
    }

    public List<Car> getCars() {
        return cars;
    }
}
