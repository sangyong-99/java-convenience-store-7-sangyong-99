package model;

import static org.assertj.core.api.Assertions.assertThat;

import controller.ApplicationController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdersTest {
    Order order1 = new Order("콜라", 3);
    Order order2 = new Order("사이다", 5);

    @AfterEach
    public void clear() {
        ApplicationController.clear();
    }

    @Test
    @DisplayName("Orders.add 함수 확인하기")
    public void orders_추가_테스트() {
        Orders.addOrder(order1);
        Orders.addOrder(order2);
        assertThat(Orders.getOrders()).hasSize(2);
        assertThat(Orders.getOrders().get(0)).isEqualTo(order1);
        assertThat(Orders.getOrders().get(1)).isEqualTo(order2);
    }
}