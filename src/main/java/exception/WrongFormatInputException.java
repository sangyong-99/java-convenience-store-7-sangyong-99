package exception;

import message.ErrorMessage;

public final class WrongFormatInputException extends IllegalArgumentException {
    public WrongFormatInputException() {
        super(ErrorMessage.WRONG_FORMAT_INPUT.getErrorMessage());
    }
}
