package org.agency.dao;

import org.agency.entity.Hotel;
import org.agency.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RoomDAOImpl implements RoomDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void bookRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.save(room);
    }

    @Override
    public List<Room> showAllRoomsForHotel(int hotelId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Hotel h join fetch h.rooms r where h.id = :id", Hotel.class)
                .setParameter("id", hotelId)
                .getSingleResult()
                .getRooms();
    }

    @Override
    public List<Room> availableByDate(String checkIn, String checkOut) {
        Session session = sessionFactory.getCurrentSession();
        Query<Room> query = session.createQuery("from Room where id not in (select o.room.id from Order o where (:checkIn between o.checkIn" +
                " and o.checkOut) or (:checkOut between o.checkIn and o.checkOut)) and " +
                "id not in (select o.room.id from Order o where ((o.checkIn between :checkIn and :checkOut) " +
                "and (o.checkOut between :checkIn and :checkOut)))", Room.class)
                .setParameter("checkIn", LocalDate.parse(checkIn))
                .setParameter("checkOut", LocalDate.parse(checkOut));
        return query.getResultList();
    }

    @Override
    public void saveRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.save(room);
    }

    @Override
    public Room getRoom(int roomId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Room.class, roomId);
    }

}
