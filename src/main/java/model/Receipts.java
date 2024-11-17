package model;

import java.util.ArrayList;
import java.util.List;

public final class Receipts {
    private static final List<Purchase> receipts = new ArrayList<>();

    private Receipts() {}

    public static void clear() {
        receipts.clear();
    }

    public static void add(Purchase purchase) {
        receipts.add(purchase);
    }

    public static int membershipDiscountEligiblePrice() {
        int price = 0;
        for (Purchase purchase : receipts) {
            int discountEligiblePrice = (purchase.price() * purchase.quantity())
                    - (purchase.promotionQuantity() * purchase.buyPlusGet() * purchase.price());
            price += discountEligiblePrice;
        }
        return price;
    }

    public static List<Purchase> getPurchases() {
        return receipts;
    }
}