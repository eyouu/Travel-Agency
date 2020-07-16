package org.agency.dao;

import org.agency.entity.Order;
import org.agency.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Order> getOrders() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Order", Order.class).getResultList();
    }

    @Override
    public Order getOrder(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, orderId);
    }

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
    }

    @Override
    public List<Order> showOrdersForUser(int userId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User u join fetch u.orders o where u.id = :userId", User.class)
                .setParameter("userId", userId)
                .getSingleResult()
                .getOrders();
    }
}
