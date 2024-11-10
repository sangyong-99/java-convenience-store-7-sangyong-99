package controller;

import static org.assertj.core.api.Assertions.assertThat;
import static util.SplitUtil.createPromotionFromContent;

import dto.ProductDTO;
import model.Inventory;
import model.Order;
import model.Promotion;
import model.Promotions;
import model.Receipts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.SplitUtil;

class PurchaseControllerTest {
    @BeforeEach
    public void setUp() {
        Promotion promotion = createPromotionFromContent("탄산2+1,2,1,2024-01-01,2024-12-31");
        Promotions.add(promotion);
        ProductDTO commonProductDTO1 = SplitUtil.createProductDTOFromContent("콜라,1000,20,null");
        ProductDTO commonProductDTO2 = SplitUtil.createProductDTOFromContent("사이다,1000,10,null");
        ProductDTO promotionProductDTO = SplitUtil.createProductDTOFromContent("콜라,1000,10,탄산2+1");
        Inventory.productAdd(commonProductDTO1);
        Inventory.productAdd(commonProductDTO2);
        Inventory.productAdd(promotionProductDTO);
    }

    @AfterEach
    public void clear() {
        ApplicationController.clear();
        Inventory.clear();
    }

    @Test
    @DisplayName("프로모션 상품 주문 함수 확인하기")
    public void 프로모션_상품_주문_테스트() {
        Order order = new Order("콜라", 7);
        PurchaseController.purchaseProduct(order);
        assertThat(Receipts.getPurchases())
                .hasSize(1)
                .anySatisfy(purchase -> {
                    assertThat(purchase.quantity()).isEqualTo(7);
                    assertThat(purchase.promotionQuantity()).isEqualTo(2);
                });
    }

    @Test
    @DisplayName("일반 상품 주문 함수 확인하기")
    public void 일반_상품_주문_테스트() {
        Order order = new Order("사이다", 6);
        PurchaseController.purchaseProduct(order);
        assertThat(Receipts.getPurchases())
                .hasSize(1)
                .anySatisfy(purchase -> {
                    assertThat(purchase.quantity()).isEqualTo(6);
                    assertThat(purchase.promotionQuantity()).isEqualTo(0);
                });
    }
}