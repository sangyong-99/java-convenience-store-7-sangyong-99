package model;

import message.ReceiptsOutput;
import io.Output;
import java.util.ArrayList;
import java.util.List;

public final class Receipts {
    private static final List<Purchase> receipts = new ArrayList<>();

    private Receipts() {
    }

    public static void clear() {
        receipts.clear();
    }

    public static void add(Purchase purchase) {
        receipts.add(purchase);
    }

    public static int membershipDiscountPrice() {
        int price = 0;
        for (Purchase purchase : receipts) {
            price += (purchase.price() * purchase.quantity()) - (purchase.promotionQuantity() * purchase.buyPlusGet()
                    * purchase.price());
        }
        return price;
    }

    public static void print() {
        purchaseMessage();
        giftMessage();
        totalMessage();
    }

    private static void purchaseMessage() {
        Output.printlnMessage(ReceiptsOutput.PURCHASE_MESSAGE.getReceiptsMessage());
        for (Purchase purchase : receipts) {
            Output.printlnFormatMessage(ReceiptsOutput.PURCHASE_FORMAT_MESSAGE.getReceiptsMessage(),
                    purchase.productName(), purchase.quantity(), purchase.price() * purchase.quantity());
        }
    }

    private static void giftMessage() {
        Output.printlnMessage(ReceiptsOutput.GIFT_MESSAGE.getReceiptsMessage());
        for (Purchase purchase : receipts) {
            if (purchase.promotionQuantity() != 0) {
                Output.printlnFormatMessage(ReceiptsOutput.GIFT_FORMAT_MESSAGE.getReceiptsMessage(),
                        purchase.productName(), purchase.promotionQuantity());
            }
        }
    }

    private static void totalMessage() {
        Output.printlnMessage(ReceiptsOutput.SEPARATION.getReceiptsMessage());
        int total = totalPrice();
        int promotionTotalPrice = promotionTotalPrice();
        int membershipDiscount = membershipPrice();
        submitMoney(total - promotionTotalPrice - membershipDiscount);
    }

    private static int totalPrice() {
        int totalQuantity = 0;
        int totalPrice = 0;
        for (Purchase purchase : receipts) {
            totalQuantity += purchase.quantity();
            totalPrice += (purchase.quantity() * purchase.price());
        }
        Output.printlnFormatMessage(ReceiptsOutput.TOTAL_PRICE.getReceiptsMessage(), totalQuantity, totalPrice);
        return totalPrice;
    }

    private static int promotionTotalPrice() {
        int promotionTotalPrice = 0;
        for (Purchase purchase : receipts) {
            promotionTotalPrice += (purchase.promotionQuantity() * purchase.price());
        }
        Output.printlnFormatMessage(ReceiptsOutput.PROMOTION_TOTAL_PRICE.getReceiptsMessage(), promotionTotalPrice);
        return promotionTotalPrice;
    }

    private static int membershipPrice() {
        Output.printlnFormatMessage(ReceiptsOutput.MEMBERSHIP_DISCOUNT_PRICE.getReceiptsMessage(),
                Membership.getMembershipDiscount());
        return Membership.getMembershipDiscount();
    }

    private static void submitMoney(int money) {
        Output.printlnFormatMessage(ReceiptsOutput.SUBMIT_MONEY.getReceiptsMessage(), money);
    }
}