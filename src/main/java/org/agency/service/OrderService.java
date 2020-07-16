package org.agency.service;

import org.agency.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();

    Order getOrder(int orderId);

    void saveOrder(Order order);

    List<Order> showOrdersForUser(int userId);
}
