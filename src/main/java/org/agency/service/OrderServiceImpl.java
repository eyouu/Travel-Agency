package org.agency.service;

import org.agency.dao.OrderDAO;
import org.agency.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Override
    @Transactional
    public List<Order> getOrders() {
        return orderDAO.getOrders();
    }

    @Override
    @Transactional
    public Order getOrder(int orderId) {
        return orderDAO.getOrder(orderId);
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    @Transactional
    public List<Order> showOrdersForUser(int userId) {
        return orderDAO.showOrdersForUser(userId);
    }
}
