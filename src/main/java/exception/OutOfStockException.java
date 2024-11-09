package exception;

import message.ErrorMessage;

public final class OutOfStockException extends IllegalArgumentException {
    public OutOfStockException() {
        super(ErrorMessage.OUT_OF_STOCK.getErrorMessage());
    }
}
