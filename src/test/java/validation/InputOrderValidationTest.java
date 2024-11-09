package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import dto.ProductDTO;
import model.Inventory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.SplitUtil;

class InputOrderValidationTest {
    @BeforeAll
    public static void setUp() {
        ProductDTO commonProductDTO = SplitUtil.createProductDTOFromContent("콜라,1000,20,null");
        ProductDTO promotionProductDTO = SplitUtil.createProductDTOFromContent("콜라,1000,10,탄산2+1");
        Inventory.productAdd(commonProductDTO);
        Inventory.productAdd(promotionProductDTO);
    }

    @ParameterizedTest
    @ValueSource(strings = {"[콜라-3],[에너지바-5", "[콜라-3][에너지바-5]", "[콜라-에너지바-5]", "[콜,라-10],[사이다-3]"})
    @DisplayName("사용자 구매 입력값 예외 테스트")
    public void 사용자_구매_입력_예외_테스트(String orderInput) {
        assertThatThrownBy(()-> InputOrderValidation.inputOrderValidation(orderInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"[장난감-3]", "[콜라 -2],[콜라-3]"})
    @DisplayName("존재하지 않는 상품 입력값 예외 테스트")
    public void 존재하지_않는_상품_입력_예외_테스트(String orderInput) {
        assertThatThrownBy(()-> InputOrderValidation.inputOrderValidation(orderInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}