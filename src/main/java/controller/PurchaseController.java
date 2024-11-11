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

    public static void purchaseProduct(final Order order) {
        Product product = Inventory.getProduct(order.orderProductName());
        if (product.getPromotion() != null) {
            purchasePromotion(product, order);
        } else {
            processPurchase(product, order.purchaseCount(), 0, 0);
        }
    }

    private static void purchasePromotion(final Product product, final Order order) {
        if (order.purchaseCount() > product.getPromotionQuantity()) {
            purchasePartialPromotion(product, order);
            return;
        }
        purchaseAllPromotion(product, order);
    }

    private static void purchaseAllPromotion(final Product product, final Order order) {
        int buyPlusGet = product.getPromotion().buyPlusGet();
        int promotionGet = order.purchaseCount() / buyPlusGet * buyPlusGet;
        if (shouldOfferAdditionalPromotion(order, product, buyPlusGet)) {
            handleAdditionalPromotionOption(product, order, buyPlusGet);
            return;
        }
        processPurchase(product, 0, order.purchaseCount(), promotionGet / buyPlusGet);
    }

    private static boolean shouldOfferAdditionalPromotion(final Order order, final Product product,
                                                          final int buyPlusGet) {
        return order.purchaseCount() % buyPlusGet == product.getPromotion().buy() &&
                product.getPromotionQuantity() >= (order.purchaseCount() + 1);
    }

    private static void handleAdditionalPromotionOption(final Product product, final Order order,
                                                        final int buyPlusGet) {
        String inputValue = InputView.additionalPromotionQuantity(product.getProductName());
        int newQuantity = order.purchaseCount();
        if (Objects.equals(inputValue, "Y")) {
            newQuantity = order.purchaseCount() + 1;
        }
        processPurchase(product, 0, newQuantity, newQuantity / buyPlusGet);
    }

    private static void purchasePartialPromotion(final Product product, final Order order) {
        int buyPlusGet = product.getPromotion().buyPlusGet();
        int promotionGet = product.getPromotionQuantity() / buyPlusGet * buyPlusGet;
        String inputValue = InputView.partialPromotion(product.getProductName(), order.purchaseCount() - promotionGet);
        if (Objects.equals(inputValue, "Y")) {
            yPartialPromotion(product, order, buyPlusGet);
            return;
        }
        nPartialPromotion(product, buyPlusGet, promotionGet);
    }

    private static void yPartialPromotion(final Product product, final Order order, final int buyPlusGet) {
        processPurchase(product, order.purchaseCount() - product.getPromotionQuantity(),
                product.getPromotionQuantity(), product.getPromotionQuantity() / buyPlusGet);
    }

    private static void nPartialPromotion(final Product product, final int buyPlusGet, final int promotionGet) {
        if (promotionGet != 0) {
            processPurchase(product, 0, promotionGet, promotionGet / buyPlusGet);
        }
    }

    private static void processPurchase(final Product product, final int quantity, final int promotionQuantity,
                                        final int giftQuantity) {
        product.purchaseProduct(quantity, promotionQuantity);
        int buyPlusGet = 0;
        if (product.getPromotion() != null) {
            buyPlusGet = product.getPromotion().buyPlusGet();
        }
        Receipts.add(new Purchase(product.getProductName(), quantity + promotionQuantity,
                giftQuantity, product.getPrice(), buyPlusGet));
    }
}
