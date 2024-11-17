package validation;

import exception.WrongFormatInputException;
import exception.WrongInputException;
import java.util.Objects;

public final class InputValidation {
    public static String isNotBlank(final String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw new WrongFormatInputException();
        }
        return inputValue;
    }

    public static String isYorN(final String input) {
        if (!Objects.equals(input, "Y") && !Objects.equals(input, "N")) {
            throw new WrongInputException();
        }
        return input;
    }
}
