package model;

import view.ProductOutputFormatter;

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

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPromotionQuantity() {
        return promotionQuantity;
    }

    public Promotion getPromotion() {
        return promotion;
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
        ProductOutputFormatter formatter = new ProductOutputFormatter(this);
        return formatter.formatProductOutput();
    }
}
