package org.agency.dao;

import org.agency.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByUserName(String theUserName) {
        Session session = sessionFactory.getCurrentSession();

        Query<User> theQuery = session.createQuery("from User where userName=:uName", User.class);
        theQuery.setParameter("uName", theUserName);

        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

    @Override
    public List<User> findAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).getResultList();
    }

}
