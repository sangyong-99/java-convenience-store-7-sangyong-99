package controller;

import model.Inventory;
import model.Order;
import model.Orders;
import model.Product;
import model.Purchase;
import model.Receipts;

public final class PurchaseController {
    public static void purchaseExec() {
        Receipts.clear();
        for (Order order : Orders.getOrders()) {
            purchase(order);
        }
    }

    public static void purchase(Order order) {
        Product product = Inventory.getProduct(order.orderProductName());
        if (product.getPromotion() != null) {

        } else {
            purchaseCommon(product, order); // 행사 상품이 아니라면
        }
    }

    public static void purchaseCommon(Product product, Order order) {
        product.purchaseCommonProduct(order.purchaseCount());
        Receipts.add(new Purchase(product.getProductName(), order.purchaseCount(), 0, product.getPrice()));
    }
}
