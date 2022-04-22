package racingcar.model;

import racingcar.constants.RepeatMessage;

public class Repeat {
    private static final String NUMBER_FORMAT_REGEX = "^[0-9]+$";
    private static final int MIN_REPEAT_NUMBER = 1;
    private static final int MAX_REPEAT_NUMBER = Integer.MAX_VALUE;

    private int number;

    private Repeat(int number) {
        this.number = number;
    }

    public static Repeat valueOf(String number) {
        validNumberFormat(number);
        validIntegerRange(number);

        return new Repeat(Integer.parseInt(number));
    }

    private static void validNumberFormat(String number) {
        if (!number.matches(NUMBER_FORMAT_REGEX)) {
            throw new IllegalArgumentException(RepeatMessage.INVALID_POSITIVE_NUMBER_FORMAT);
        }
    }

    private static void validIntegerRange(String number) {
        if (isMoreThanBillionDigits(number) || isOutOfRange(Long.parseLong(number))) {
            throw new IllegalArgumentException(RepeatMessage.INVALID_NUMBER_RANGE);
        }
    }

    private static boolean isMoreThanBillionDigits(String number) {
        return number.length() > 10;
    }

    private static boolean isOutOfRange(Long number) {
        return number < MIN_REPEAT_NUMBER || number > MAX_REPEAT_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}
