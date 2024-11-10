package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReceiptsTest {
    Purchase purchase = new Purchase("콜라", 6, 1, 1500, 3);

    @BeforeEach
    public void clear() {
        Receipts.clear();
    }

    @Test
    @DisplayName("영수증에 구매 목록 추가 확인하기")
    public void 영수증_구매목록_추가_테스트() {
        Receipts.add(purchase);
        assertThat(Receipts.getPurchases().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("멤버십 할인 가격 구하는 함수 확인하기")
    public void 멤버십_할인가격_함수_테스트() {
        Receipts.add(purchase);
        assertThat(Receipts.membershipDiscountEligiblePrice()).isEqualTo(4500);
    }
}