package org.agency.service;

import org.agency.dao.RoomDAO;
import org.agency.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomDAO roomDAO;

    @Override
    @Transactional
    public void bookRoom(Room room) {
        roomDAO.bookRoom(room);
    }

    @Override
    @Transactional
    public List<Room> showAllRoomsForHotel(int hotelId) {
        return roomDAO.showAllRoomsForHotel(hotelId);
    }

    @Override
    @Transactional
    public List<Room> availableByDate(String checkIn, String checkOut) {
        return roomDAO.availableByDate(checkIn, checkOut);
    }

    @Override
    @Transactional
    public void saveRoom(Room room) {
        roomDAO.saveRoom(room);
    }

    @Override
    @Transactional
    public Room getRoom(int roomId) {
        return roomDAO.getRoom(roomId);
    }
}
