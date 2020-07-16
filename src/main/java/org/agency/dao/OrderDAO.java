package org.agency.dao;

import org.agency.entity.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getOrders();

    Order getOrder(int orderId);

    void saveOrder(Order order);

    List<Order> showOrdersForUser(int userId);

}
