package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {
    @ParameterizedTest
    @ValueSource(strings = {"d", "", "  ", "YN"})
    @DisplayName("사용자값 Y or N 아닐때 예외 확인하기")
    void 사용자값_YorN_아닐때_테스트(String input) {
        assertThatThrownBy(() -> InputValidation.isYorN(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "      "})
    @DisplayName("사용자값 비어있을때 예외 확인하기")
    void 사용자값_비어있을때_테스트(String input) {
        assertThatThrownBy(() -> InputValidation.isNotBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}