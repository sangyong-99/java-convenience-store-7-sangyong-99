package validation;

import model.Order;
import model.Orders;
import util.RegexCheckerUtil;
import util.SplitUtil;

public final class InputOrderValidation {
    public static void inputOrderValidation(final String content) throws IllegalArgumentException {
        String[] inputOrder = SplitUtil.splitContent(content);
        for (String order : inputOrder) {
            Order productOrder = RegexCheckerUtil.orderRegexChecker(order);
            // 추가 구현
            Orders.addOrder(productOrder);
        }
    }
}
