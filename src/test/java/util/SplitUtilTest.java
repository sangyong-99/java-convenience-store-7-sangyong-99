package util;

import static org.assertj.core.api.Assertions.assertThat;

import dto.ProductDTO;
import java.time.LocalDate;
import model.Promotion;
import model.Promotions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SplitUtilTest {
    private static final String PROMOTION_NAME = "Holiday Sale";
    private static final int PROMOTION_BUY = 1;
    private static final int PROMOTION_GET = 1;
    private static final LocalDate PROMOTION_START = LocalDateUtil.parse("2024-11-01");
    private static final LocalDate PROMOTION_END = LocalDateUtil.parse("2024-11-30");
    private static final int PRODUCT_PRICE = 1000;
    private static final int PRODUCT_QUANTITY = 5;

    @BeforeAll
    public static void setUp() {
        Promotions.add(new Promotion(PROMOTION_NAME, PROMOTION_BUY, PROMOTION_GET, PROMOTION_START, PROMOTION_END));
    }

    @Test
    @DisplayName("프로모션 정보 문자열 분할(Split)을 통해 Promotion 인스턴스 반환 함수 확인하기")
    public void 프로모션_문자열_분할_생성_테스트() {
        String content = "Holiday Sale,1,1,2024-11-01,2024-11-30";
        Promotion promotion = SplitUtil.createPromotionFromContent(content);
        assertPromotion(promotion);
    }

    @Test
    @DisplayName("프로모션 진행 중인 상품 문자열 분할(Split)을 통해 Product 반환 함수 확인하기")
    public void 프로모션_상품_분할_생성_테스트() {
        String content = "Laptop,1000,5,Holiday Sale";
        ProductDTO productDTO = SplitUtil.createProductDTOFromContent(content);
        assertProductDTO(productDTO, Promotions.getPromotion(PROMOTION_NAME));
    }

    @Test
    @DisplayName("프로모션 진행 중이 아닌 상품 문자열 분할(Split)을 통해 Product 반환 함수 확인하기")
    public void 프로모션_아닌_상품_분할_생성_테스트() {
        String content = "Laptop,1000,5,null";
        ProductDTO productDTO = SplitUtil.createProductDTOFromContent(content);
        assertProductDTO(productDTO, null);
    }

    private void assertPromotion(Promotion promotion) {
        assertThat(promotion.promotionName()).isEqualTo(SplitUtilTest.PROMOTION_NAME);
        assertThat(promotion.buy()).isEqualTo(SplitUtilTest.PROMOTION_BUY);
        assertThat(promotion.get()).isEqualTo(SplitUtilTest.PROMOTION_GET);
        assertThat(promotion.startTime()).isEqualTo(SplitUtilTest.PROMOTION_START);
        assertThat(promotion.endTime()).isEqualTo(SplitUtilTest.PROMOTION_END);
    }

    private void assertProductDTO(ProductDTO productDTO, Promotion promotion) {
        assertThat(productDTO.productName()).isEqualTo("Laptop");
        assertThat(productDTO.price()).isEqualTo(SplitUtilTest.PRODUCT_PRICE);
        assertThat(productDTO.quantity()).isEqualTo(SplitUtilTest.PRODUCT_QUANTITY);
        assertThat(productDTO.promotion()).isEqualTo(promotion);
    }
}