package controller;

import static org.assertj.core.api.Assertions.assertThat;

import model.Purchase;
import model.Receipts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MembershipControllerTest {
    @AfterEach
    public void clear() {
        ApplicationController.clear();
    }

    @Test
    @DisplayName("멤버십 할인 금액 확인하기")
    public void 멤버쉽_할인금액_테스트() {
        Purchase purchase = new Purchase("콜라", 6, 1, 1000, 3);
        Receipts.add(purchase);
        assertThat(MembershipController.membershipCalculate()).isEqualTo(900);
    }
}