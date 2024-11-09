package view;

import constant.OutputConstant;
import model.Product;

public class ProductOutputFormatter {
    private final Product product;

    public ProductOutputFormatter(Product product) {
        this.product = product;
    }

    public String formatProductOutput() {
        StringBuilder outputBuilder = new StringBuilder();
        if (product.getPromotion() != null) {
            outputBuilder.append(formatPromotionProductOutput()).append("\n");
        }
        outputBuilder.append(formatCommonProductOutput());
        return outputBuilder.toString();
    }

    private String formatPromotionProductOutput() {
        return String.format(OutputConstant.PROMOTION_PRODUCT_STR_FORMAT.getConstant(),
                product.getProductName(),
                product.getPrice(),
                formatQuantity(product.getPromotionQuantity()),
                product.getPromotion().promotionName());
    }

    private String formatCommonProductOutput() {
        return String.format(OutputConstant.COMMON_PRODUCT_STR_FORMAT.getConstant(),
                product.getProductName(),
                product.getPrice(),
                formatQuantity(product.getQuantity()));
    }

    private String formatQuantity(int quantity) {
        if (quantity == 0) {
            return OutputConstant.NO_INVENTORY.getConstant();
        }
        return quantity + OutputConstant.COUNT.getConstant();
    }
}
