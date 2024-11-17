package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocalDateUtilTest {
    public LocalDate startDate;
    public LocalDate endDate;

    @Test
    @DisplayName("오늘 날짜가 시작 날짜와 종료 날짜 사이에 있는지 확인하기")
    public void 오늘날짜가_기간내인지_테스트() {
        startDate = LocalDateUtil.parse("2024-11-01");
        endDate = LocalDateUtil.parse("2024-11-12");
        assertThat(LocalDateUtil.isWithinPeriod(startDate, endDate)).isTrue();
    }
}