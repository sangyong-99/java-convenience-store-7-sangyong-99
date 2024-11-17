package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PromotionsTest {
    @BeforeEach
    public void setUp() {
        Promotions.add(
                new Promotion("Holiday Sale", 1, 1, LocalDate.parse("2024-11-01"), LocalDate.parse("2024-11-30")));
        Promotions.add(
                new Promotion("Black Friday", 2, 1, LocalDate.parse("2024-11-29"), LocalDate.parse("2024-11-30")));
    }

    @Test
    @DisplayName("프로모션 조회 확인하기")
    public void 프로모션_가져오기_테스트() {
        Promotion holidaySale = Promotions.getPromotion("Holiday Sale");
        assertThat(holidaySale).isNotNull();
        Promotion blackFriday = Promotions.getPromotion("Black Friday");
        assertThat(blackFriday).isNotNull();
        Promotion blackMonday = Promotions.getPromotion("Black Monday");
        assertThat(blackMonday).isNull();
    }
}