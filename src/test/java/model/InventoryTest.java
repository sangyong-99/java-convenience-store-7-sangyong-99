package model;

import static org.assertj.core.api.Assertions.assertThat;
import static util.SplitUtil.createPromotionFromContent;

import dto.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.SplitUtil;

class InventoryTest {
    private ProductDTO commonProductDTO;
    private ProductDTO promotionProductDTO;

    @BeforeEach
    public void setUp() {
        Promotion promotion = createPromotionFromContent("탄산2+1,2,1,2024-01-01,2024-12-31");
        Promotions.add(promotion);
        commonProductDTO = SplitUtil.createProductDTOFromContent("콜라,1000,20,null");
        promotionProductDTO = SplitUtil.createProductDTOFromContent("콜라,1000,10,탄산2+1");
        Inventory.clear();
    }

    @Test
    @DisplayName("상품재고 없을 때 일반 재고 추가 테스트(noProductAdd)")
    public void 상품재고_없을때_일반재고_추가_테스트() {
        Inventory.productAdd(commonProductDTO);
        assertThat(Inventory.printInventory()).isEqualTo("- 콜라 1,000원 20개\n");
    }

    @Test
    @DisplayName("상품재고 없을 때 행사재고 추가 테스트(noProductAdd)")
    public void 상품재고_없을때_행사재고_추가_테스트() {
        Inventory.productAdd(promotionProductDTO);
        assertThat(Inventory.printInventory()).isEqualTo("- 콜라 1,000원 10개 탄산2+1\n"
                + "- 콜라 1,000원 재고 없음\n");
    }

    @Test
    @DisplayName("행사상품재고 있을 때 일반 재고 추가 테스트(existProductAdd)")
    public void 상품재고_있을때_일반재고_추가_테스트() {
        Inventory.productAdd(promotionProductDTO);
        Inventory.productAdd(commonProductDTO);
        assertThat(Inventory.printInventory()).isEqualTo("- 콜라 1,000원 10개 탄산2+1\n"
                + "- 콜라 1,000원 20개\n");
    }

    @Test
    @DisplayName("행사상품재고 있을 때 일반 재고 추가 테스트2(existProductAdd)")
    public void 상품재고_있을때_일반재고_추가_테스트2() {
        Inventory.productAdd(commonProductDTO);
        Inventory.productAdd(promotionProductDTO);
        System.out.println(Inventory.printInventory());
        assertThat(Inventory.printInventory()).isEqualTo("- 콜라 1,000원 10개 탄산2+1\n"
                + "- 콜라 1,000원 20개\n");
    }
}