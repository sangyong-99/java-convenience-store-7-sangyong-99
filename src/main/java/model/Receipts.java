package model;

import java.util.ArrayList;
import java.util.List;

public final class Receipts {
    private static final List<Purchase> receipts = new ArrayList<>();
    private static final boolean membershipDiscount = false;

    private Receipts() {
    }

    public static void clear() {
        receipts.clear();
    }

    public static void add(Purchase purchase) {
        receipts.add(purchase);
    }

    public static void print() {
        for(Purchase purchase: receipts) {
            System.out.println(purchase);
        }
    }
}
