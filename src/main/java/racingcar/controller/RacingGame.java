package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import racingcar.model.Names;
import racingcar.view.Receipt;

public class RacingGame {
    private Cars cars;

    private RacingGame(Cars cars) {
        this.cars = cars;
    }

    public static void start() {
        set();
    }

    private static void set() {
        new RacingGame(setCarNames());
    }

    private static Cars setCarNames() {
        try {
            Receipt.printInputCarNames();
            Names names = Names.valueOf(Console.readLine());
            return Cars.create(names);
        } catch (IllegalArgumentException e) {
            Receipt.printErrorMessage(e);
            return setCarNames();
        }
    }
}
