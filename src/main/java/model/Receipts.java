package model;

import java.util.ArrayList;
import java.util.List;

public final class Receipts {
    private static final List<Purchase> receipts = new ArrayList<>();
    private static boolean membershipDiscount = false;

    private Receipts() {
    }

    public static void clear() {
        receipts.clear();
        membershipDiscount = false;
    }

    public static void isMembershipDiscount() {
        membershipDiscount = true;
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
        for(Purchase purchase: receipts) {
            System.out.println(purchase);
        }
    }
}
