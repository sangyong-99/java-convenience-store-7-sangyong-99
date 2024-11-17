package model;

import java.util.HashMap;
import java.util.Map;

public final class Promotions {
    private static final Map<String, Promotion> promotion = new HashMap<>();

    private Promotions() {
    }

    public static void add(final Promotion promotion) {
        Promotions.promotion.put(promotion.promotionName(), promotion);
    }

    public static Promotion getPromotion(String promotionName) {
        return promotion.get(promotionName);
    }
}
