package model;

import constant.OutputConstant;

public class Product {
    private final String productName;
    private final int price;
    private int quantity;
    private int promotionQuantity;
    private Promotion promotion;

    public Product(String productName, int price, int quantity, int promotionQuantity, Promotion promotion) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.promotionQuantity = promotionQuantity;
        this.promotion = promotion;
    }

    public void setPromotionProduct(int promotionQuantity, Promotion promotion) {
        this.promotionQuantity = promotionQuantity;
        this.promotion = promotion;
    }

    public void setCommonProduct(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder outputBuilder = new StringBuilder();
        if (promotion != null) {
            outputBuilder.append(PromotionProductOutput()).append("\n");
        }
        outputBuilder.append(CommonProductOutput());
        return outputBuilder.toString();
    }

    private String PromotionProductOutput() {
        return String.format(OutputConstant.PROMOTION_PRODUCT_STR_FORMAT.getConstant(), productName, price,
                quantityOutput(promotionQuantity),
                promotion.promotionName());
    }

    private String CommonProductOutput() {
        return String.format(OutputConstant.COMMON_PRODUCT_STR_FORMAT.getConstant(), productName, price,
                quantityOutput(quantity));
    }

    private String quantityOutput(int quantity) {
        if (quantity == 0) {
            return OutputConstant.NO_INVENTORY.getConstant();
        }
        return quantity + OutputConstant.COUNT.getConstant();
    }
}
