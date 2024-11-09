package view;

import io.Input;
import io.Output;
import message.IOMessage;

public final class InputView {
    public static String inputOrder() {
        Output.printlnMessage(IOMessage.ORDER_MESSAGE.getMessage());
        return Input.inputMessage();
    }

    public static String partialPromotion(String productName, int count) {
        String partialPromotionMessage = String.format(IOMessage.PARTIAL_PROMOTION_MESSAGE.getMessage(), productName,
                count);
        Output.printlnMessage(partialPromotionMessage);
        return Input.inputYOrN();
    }

    public static String additionalPromotionQuantity(String productName) {
        String additionalPromotionQuantityMessage = String.format(
                IOMessage.ADDITIONAL_PROMOTION_QUANTITY_MESSAGE.getMessage(), productName);
        Output.printlnMessage(additionalPromotionQuantityMessage);
        return Input.inputYOrN();
    }

    public static String membershipDiscount() {
        Output.printlnMessage(IOMessage.MEMBERSHIP_DISCOUNT_MESSAGE.getMessage());
        return Input.inputYOrN();
    }

    public static String exitCheck() {
        Output.printlnMessage(IOMessage.EXIT_CHECK_MESSAGE.getMessage());
        return Input.inputYOrN();
    }
}
