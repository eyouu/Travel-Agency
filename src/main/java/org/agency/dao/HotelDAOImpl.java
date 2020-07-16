package org.agency.dao;

import org.agency.entity.Hotel;
import org.agency.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelDAOImpl implements HotelDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Hotel> getHotels() {
        Session session = sessionFactory.getCurrentSession();

        Query<Hotel> query = session.createQuery("from Hotel", Hotel.class);
        return query.getResultList();
    }

    @Override
    public void saveHotel(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(hotel);
    }

    @Override
    public List<Hotel> searchHotelByCountry(String countryName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Hotel> query = session.createQuery("from Hotel where lower(country) like :theCountry", Hotel.class);
        query.setParameter("theCountry", "%" + countryName.toLowerCase() + "%");
        return query.getResultList();
    }

    @Override
    public Hotel getHotel(int hotelId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Hotel.class, hotelId);
    }
}
