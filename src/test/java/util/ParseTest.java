package util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParseTest {
    @Test
    @DisplayName("String 값을 Integer로 변환 예외 확인하기")
    public void 숫자_변환_예외_테스트() {
        assertThatThrownBy(() -> Parse.parseInteger("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("String 값을 Integer로 변환 확인하기")
    public void 숫자_변환_테스트() {
        assertThat(Parse.parseInteger("12")).isEqualTo(12);
    }
}