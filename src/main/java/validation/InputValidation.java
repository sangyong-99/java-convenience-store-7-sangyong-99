package validation;

import exception.WrongInputException;

public final class InputValidation {
    public static String isNotBlank(final String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw new WrongInputException();
        }
        return inputValue;
    }
}
