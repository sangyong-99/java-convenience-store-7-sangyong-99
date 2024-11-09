package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReceiptsTest {
    @Test
    @DisplayName("영수증에 구매 목록 추가 확인하기")
    public void 영수증_구매목록_추가_테스트() {
        Purchase purchase = new Purchase("콜라", 2, 0, 1500);
        Receipts.add(purchase);
    }
}