package util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RegexCheckerUtilTest {
    @ParameterizedTest
    @ValueSource(strings = {"[감자칩-q]", "사이다-2]", "[사이다-1", "[ -1]", "[사이다-0]", "ㅂ[사이다-12]", "[사이다-2]q", "[사이다- 1]"})
    @DisplayName("입력값 형식 예외 발생 확인하기")
    public void 입력값_정규식_예외_테스트(String input) {
        assertThatThrownBy(() -> RegexCheckerUtil.orderRegexChecker(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}