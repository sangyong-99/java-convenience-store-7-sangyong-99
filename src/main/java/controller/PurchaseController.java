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
        Receipts.clear();
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
        processPurchase(product, 0, promotionGet, product.getPromotionQuantity() / buyPlusGet);
    }

    private static void processPurchase(Product product, int quantity, int promotionQuantity, int giftQuantity) {
        product.purchaseProduct(quantity, promotionQuantity);
        Receipts.add(
                new Purchase(product.getProductName(), quantity + promotionQuantity, giftQuantity, product.getPrice()));
    }
}
