package exception;

import message.ErrorMessage;

public final class LoadFileException extends IllegalArgumentException {
    public LoadFileException() {
        super(ErrorMessage.LOAD_FILE_FAIL_MESSAGE.getErrorMessage());
    }
}
