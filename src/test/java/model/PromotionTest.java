package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.LocalDateUtil;

class PromotionTest {
    @Test
    @DisplayName("오늘이 프로모션 기간일때 확인하기")
    public void 프로모션_기간일때_테스트() {
        LocalDate startTime = LocalDateUtil.parse("2024-11-06");
        LocalDate endTime = LocalDateUtil.parse("2024-12-30");
        assertThat(Promotion.currentPromotion(startTime, endTime)).isEqualTo(true);
    }

    @Test
    @DisplayName("오늘이 프로모션 기간 아닐때 확인하기")
    public void 프로모션_기간_아닐때_테스트() {
        LocalDate startTime = LocalDateUtil.parse("2023-11-05");
        LocalDate endTime = LocalDateUtil.parse("2024-11-06");
        assertThat(Promotion.currentPromotion(startTime, endTime)).isEqualTo(false);
    }
}