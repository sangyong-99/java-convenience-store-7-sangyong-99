package view;

import io.Output;
import java.util.ArrayList;
import java.util.List;
import model.Membership;
import model.Purchase;

public final class ReceiptsOutput {
    private static List<Purchase> receipts = new ArrayList<>();

    public ReceiptsOutput(List<Purchase> receipts) {
        ReceiptsOutput.receipts = receipts;
    }

    public void print() {
        purchaseMessage();
        giftMessage();
        totalMessage();
    }

    private void purchaseMessage() {
        Output.printlnMessage(message.ReceiptsOutput.PURCHASE_MESSAGE.getReceiptsMessage());
        for (Purchase purchase : receipts) {
            Output.printlnFormatMessage(message.ReceiptsOutput.PURCHASE_FORMAT_MESSAGE.getReceiptsMessage(),
                    purchase.productName(), purchase.quantity(), purchase.price() * purchase.quantity());
        }
    }

    private void giftMessage() {
        Output.printlnMessage(message.ReceiptsOutput.GIFT_MESSAGE.getReceiptsMessage());
        for (Purchase purchase : receipts) {
            if (purchase.promotionQuantity() != 0) {
                Output.printlnFormatMessage(message.ReceiptsOutput.GIFT_FORMAT_MESSAGE.getReceiptsMessage(),
                        purchase.productName(), purchase.promotionQuantity());
            }
        }
    }

    private void totalMessage() {
        Output.printlnMessage(message.ReceiptsOutput.SEPARATION.getReceiptsMessage());
        int total = totalPrice();
        int promotionTotalPrice = promotionTotalPrice();
        int membershipDiscount = membershipPrice();
        submitMoney(total - promotionTotalPrice - membershipDiscount);
    }

    private int totalPrice() {
        int totalQuantity = 0;
        int totalPrice = 0;
        for (Purchase purchase : receipts) {
            totalQuantity += purchase.quantity();
            totalPrice += (purchase.quantity() * purchase.price());
        }
        Output.printlnFormatMessage(message.ReceiptsOutput.TOTAL_PRICE.getReceiptsMessage(), totalQuantity, totalPrice);
        return totalPrice;
    }

    private int promotionTotalPrice() {
        int promotionTotalPrice = 0;
        for (Purchase purchase : receipts) {
            promotionTotalPrice += (purchase.promotionQuantity() * purchase.price());
        }
        Output.printlnFormatMessage(message.ReceiptsOutput.PROMOTION_TOTAL_PRICE.getReceiptsMessage(), promotionTotalPrice);
        return promotionTotalPrice;
    }

    private int membershipPrice() {
        Output.printlnFormatMessage(message.ReceiptsOutput.MEMBERSHIP_DISCOUNT_PRICE.getReceiptsMessage(),
                Membership.getMembershipDiscount());
        return Membership.getMembershipDiscount();
    }

    private void submitMoney(int money) {
        Output.printlnFormatMessage(message.ReceiptsOutput.SUBMIT_MONEY.getReceiptsMessage(), money);
    }
}