package model;

public record Purchase(String productName, int quantity, int promotionQuantity, int price, int buyPlusGet) {
}
