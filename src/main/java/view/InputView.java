package view;

import io.Input;
import io.Output;
import message.IOMessage;

public final class InputView {
    public static String inputOrder() {
        Output.printlnMessage(IOMessage.ORDER_MESSAGE.getMessage());
        return Input.inputMessage();
    }

    public static String PartialPromotion(String productName, int count) {
        String partialPromotionMessage = String.format(IOMessage.PARTIAL_PROMOTION_MESSAGE.getMessage(), productName, count);
        Output.printlnMessage(partialPromotionMessage);
        return Input.inputYOrN();
    }
}
