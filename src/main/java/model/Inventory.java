package model;

import dto.ProductDTO;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Inventory {
    private static final Map<String, Product> productInventory = new LinkedHashMap<>();

    private Inventory() {
    }

    public static void productAdd(final ProductDTO productDTO) {
        Product product = Inventory.getProduct(productDTO.productName());
        if (product == null) {
            noProductAdd(productDTO);
            return;
        }
        existProductAdd(product, productDTO);
    }

    private static void existProductAdd(final Product product, final ProductDTO productDTO) {
        if (productDTO.promotion() == null) {
            product.setCommonProduct(productDTO.quantity());
            return;
        }
        product.setPromotionProduct(productDTO.quantity(), productDTO.promotion());
    }

    private static void noProductAdd(final ProductDTO productDTO) {
        if (productDTO.promotion() == null) {
            Product product = new Product(productDTO.productName(), productDTO.price(), productDTO.quantity(), 0, null);
            putProduct(productDTO.productName(), product);
            return;
        }
        Product product = new Product(productDTO.productName(), productDTO.price(), 0, productDTO.quantity(),
                productDTO.promotion());
        putProduct(productDTO.productName(), product);
    }

    private static void putProduct(String productName, Product product) {
        productInventory.put(productName, product);
    }

    public static Product getProduct(String name) {
        return productInventory.get(name);
    }

    public static String printInventory() {
        StringBuilder sb = new StringBuilder();
        for (Product product : productInventory.values()) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }
}

