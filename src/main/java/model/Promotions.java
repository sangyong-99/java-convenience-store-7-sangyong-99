package model;

import java.util.ArrayList;
import java.util.List;

public final class Promotions {
    private static final List<Promotion> promotionList = new ArrayList<>();

    private Promotions() {
    }

    public static void add(final Promotion promotion) {
        promotionList.add(promotion);
    }
}
