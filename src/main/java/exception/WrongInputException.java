package exception;

import message.ErrorMessage;

public final class WrongInputException extends IllegalArgumentException {
    public WrongInputException() {
        super(ErrorMessage.WRONG_INPUT.getErrorMessage());
    }
}
