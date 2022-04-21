package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constants.NameMessage;

public class Names {
    private static final String NAME_SEPARATOR_CHARACTER = ",";
    private static final String ONLY_SEPARATOR_CHARACTER_REGEX = "^,+$";

    private List<Name> names;

    private Names(String[] nameArray) {
        createNames(nameArray);
    }

    public static Names create(String names) {
        validEmptyNames(names);
        String[] nameArray = separateNames(names);
        validDuplicateNames(nameArray);
        validLengthNames(nameArray);

        return new Names(nameArray);
    }

    private static String[] separateNames(String inputNames) {
        return inputNames.split(NAME_SEPARATOR_CHARACTER);
    }

    private void createNames(String[] nameArray) {
        names = new ArrayList<>();
        for (String name : nameArray) {
            names.add(Name.valueOf(name));
        }
    }

    private static void validEmptyNames(String inputNames) {
        if (isEmptyNames(inputNames) || isOnlySeparatorCharacter(inputNames)) {
            throw new IllegalArgumentException(NameMessage.EMPTY_INPUT_NAMES);
        }
    }

    private static boolean isEmptyNames(String inputNames) {
        return inputNames.isEmpty();
    }

    private static boolean isOnlySeparatorCharacter(String inputNames) {
        return inputNames.matches(ONLY_SEPARATOR_CHARACTER_REGEX);
    }

    private static void validDuplicateNames(String[] nameArray) {
        Set<String> validationSet = new HashSet<>(Arrays.asList(nameArray));
        if (validationSet.size() != nameArray.length) {
            throw new IllegalArgumentException(NameMessage.DUPLICATE_INPUT_NAME);
        }
    }

    private static void validLengthNames(String[] nameArray) {
        for (String name : nameArray) {
            Name.validNameLength(name);
        }
    }
}
