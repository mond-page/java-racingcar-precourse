package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import racingcar.model.Names;
import racingcar.model.Repeat;
import racingcar.view.Receipt;

public class RacingGame {
    private Cars cars;
    private Repeat repeat;

    private RacingGame(Cars cars, Repeat repeat) {
        this.cars = cars;
        this.repeat = repeat;
    }

    public static void start() {
        set();
    }

    private static void set() {
        new RacingGame(setCarNames(), setRepeatNumbers());
    }

    private static Repeat setRepeatNumbers() {
        try {
            Receipt.printInputRepeatNumber();
            return Repeat.valueOf(Console.readLine());
        } catch (IllegalArgumentException e) {
            Receipt.printErrorMessage(e);
            return setRepeatNumbers();
        }
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
