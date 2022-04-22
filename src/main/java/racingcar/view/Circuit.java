package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Position;

public final class Circuit {
    private static final String ONE_POSITION_VALUE = "-";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String REPEAT_SEPARATION_MESSAGE = "\n";
    private static final String CAR_POSITION_MESSAGE = "%s : %s\n";

    private Circuit() {
    }

    public static void printRaceStart() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCarsPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            printCarPosition(car);
        }
        System.out.print(REPEAT_SEPARATION_MESSAGE);
    }

    private static void printCarPosition(Car car) {
        System.out.printf(CAR_POSITION_MESSAGE, car.getName(), printPosition(car.getPosition()));
    }

    private static String printPosition(Position position) {
        StringBuilder sb = new StringBuilder();
        for (int number = 0; number < position.getValue(); number++) {
            sb.append(ONE_POSITION_VALUE);
        }
        return sb.toString();
    }
}
