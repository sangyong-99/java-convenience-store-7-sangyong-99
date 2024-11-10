package controller;

import java.util.Objects;
import model.Inventory;
import model.Order;
import model.Orders;
import model.Product;
import model.Purchase;
import model.Receipts;
import view.InputView;

public final class PurchaseController {
    public static void purchaseExec() {
        for (Order order : Orders.getOrders()) {
            purchaseProduct(order);
        }
    }

    public static void purchaseProduct(Order order) {
        Product product = Inventory.getProduct(order.orderProductName());
        if (product.getPromotion() != null) {
            purchasePromotion(product, order); // 프로모션 행사 상품 구매
        } else {
            processPurchase(product, order.purchaseCount(), 0, 0); // 행사 상품이 아니라면
        }
    }


    public static void purchasePromotion(Product product, Order order) {
        if (order.purchaseCount() > product.getPromotionQuantity()) {
            purchasePartialPromotion(product, order);
            return;
        }
        purchaseAllPromotion(product, order);
    }

    public static void purchaseAllPromotion(Product product, Order order) {
        int buyPlusGet = product.getPromotion().buyPlusGet();
        int promotionGet = order.purchaseCount() / buyPlusGet * buyPlusGet;
        if (shouldOfferAdditionalPromotion(order, product, buyPlusGet)) {
            handleAdditionalPromotionOption(product, order, buyPlusGet);
            return;
        }
        processPurchase(product, 0, order.purchaseCount(), promotionGet / buyPlusGet);
    }

    private static boolean shouldOfferAdditionalPromotion(Order order, Product product, int buyPlusGet) {
        return order.purchaseCount() % buyPlusGet == product.getPromotion().buy() &&
                product.getPromotionQuantity() >= (order.purchaseCount() + 1);
    }

    private static void handleAdditionalPromotionOption(Product product, Order order, int buyPlusGet) {
        String inputValue = InputView.additionalPromotionQuantity(product.getProductName());
        int newQuantity = order.purchaseCount();
        if (Objects.equals(inputValue, "Y")) {
            newQuantity = order.purchaseCount() + 1;
        }
        processPurchase(product, 0, newQuantity, newQuantity / buyPlusGet);
    }


    public static void purchasePartialPromotion(Product product, Order order) {
        int buyPlusGet = product.getPromotion().buyPlusGet();
        int promotionGet = product.getPromotionQuantity() / buyPlusGet * buyPlusGet;
        String inputValue = InputView.partialPromotion(product.getProductName(), order.purchaseCount() - promotionGet);
        if (Objects.equals(inputValue, "Y")) {
            yPartialPromotion(product, order, buyPlusGet);
            return;
        }
        nPartialPromotion(product, buyPlusGet, promotionGet);
    }

    public static void yPartialPromotion(Product product, Order order, int buyPlusGet) {
        processPurchase(product, order.purchaseCount() - product.getPromotionQuantity(),
                product.getPromotionQuantity(), product.getPromotionQuantity() / buyPlusGet);
    }

    public static void nPartialPromotion(Product product, int buyPlusGet, int promotionGet) {
        if (promotionGet != 0) {
            processPurchase(product, 0, promotionGet, promotionGet / buyPlusGet);
        }
    }

    private static void processPurchase(Product product, int quantity, int promotionQuantity, int giftQuantity) {
        product.purchaseProduct(quantity, promotionQuantity);
        int buyPlusGet = 0;
        if (product.getPromotion() != null) {
            buyPlusGet = product.getPromotion().buyPlusGet();
        }
        Receipts.add(
                new Purchase(product.getProductName(), quantity + promotionQuantity, giftQuantity, product.getPrice(),
                        buyPlusGet));
    }
}
