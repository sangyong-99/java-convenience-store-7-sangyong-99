package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.LocalDateUtil;

class ProductTest {
    private Product product;
    private Promotion promotion;

    @BeforeEach
    public void setUp() {
        promotion = new Promotion("Holiday Sale", 1, 1, LocalDateUtil.parse("2024-11-01"),
                LocalDateUtil.parse("2024-11-30"));
        product = new Product("Laptop", 1000, 5, 0, null);
    }

    @Test
    @DisplayName("PromotionProduct 설정 테스트")
    public void testSetPromotionProduct() {
        String expectValue = "- Laptop 1,000원 3개 Holiday Sale\n" + "- Laptop 1,000원 5개";
        product.setPromotionProduct(3, promotion);
        assertThat(product.toString()).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("CommonProduct 설정 테스트")
    public void testSetCommonProduct() {
        String expectValue = "- Laptop 1,000원 10개";
        product.setCommonProduct(10);
        assertThat(product.toString()).contains(expectValue);
    }

    @Test
    @DisplayName("일반 상품 구매 확인하기")
    public void testPurchaseCommonProduct() {
        product.purchaseCommonProduct(3);
        assertThat(product.getQuantity()).isEqualTo(2);
    }
}