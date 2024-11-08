package util;

import exception.WrongInputException;

public final class Parse {
    public static int parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException error){
            throw new WrongInputException();
        }
    }
}
