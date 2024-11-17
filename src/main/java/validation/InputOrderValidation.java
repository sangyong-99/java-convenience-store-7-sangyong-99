package validation;

import exception.NotExistProductException;
import exception.OutOfStockException;
import model.Inventory;
import model.Order;
import model.Orders;
import model.Product;
import util.RegexCheckerUtil;
import util.SplitUtil;

public final class InputOrderValidation {
    public static void inputOrderValidation(final String content) throws IllegalArgumentException {
        String[] inputOrder = SplitUtil.splitContent(content);
        for (String order : inputOrder) {
            Order productOrder = RegexCheckerUtil.orderRegexChecker(order);
            orderValidation(productOrder);
            Orders.addOrder(productOrder);
        }
    }

    private static void orderValidation(final Order productOrder) {
        Product product = Inventory.getProduct(productOrder.orderProductName());
        if (product == null) {
            throw new NotExistProductException();
        }
        if (product.getTotalQuantity() < productOrder.purchaseCount()) {
            throw new OutOfStockException();
        }
    }
}
