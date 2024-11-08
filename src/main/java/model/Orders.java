package model;

import java.util.ArrayList;
import java.util.List;

public final class Orders {
    private static final List<Order> orders = new ArrayList<>();

    public static void addOrder(Order order) {
        orders.add(order);
    }

    public static List<Order> getOrders() {
        return orders;
    }

    public static void clearOrders() {
        orders.clear();
    }
}
