package exception;

import message.ErrorMessage;

public final class NotExistProductException extends IllegalArgumentException {
    public NotExistProductException(){
        super(ErrorMessage.NOT_EXIST_PRODUCT.getErrorMessage());
    }
}
