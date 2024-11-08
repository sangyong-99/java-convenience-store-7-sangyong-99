package view;

import io.Input;
import io.Output;
import message.IOMessage;

public final class InputView {
    public static String inputOrder() {
        Output.printlnMessage(IOMessage.ORDER_MESSAGE.getMessage());
        return Input.inputMessage();
    }
}
