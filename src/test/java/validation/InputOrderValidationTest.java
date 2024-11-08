package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputOrderValidationTest {
    @ParameterizedTest
    @ValueSource(strings = {"[콜라-3],[에너지바-5", "[콜라-3][에너지바-5]", "[콜라-에너지바-5]", "[콜,라-10],[사이다-3]"})
    @DisplayName("사용자 구매 입력값 예외 테스트")
    public void 사용자_구매_입력_예외_테스트(String orderInput) {
        assertThatThrownBy(()-> InputOrderValidation.inputOrderValidation(orderInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}