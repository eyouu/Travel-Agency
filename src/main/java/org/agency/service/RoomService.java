package org.agency.service;

import org.agency.entity.Room;
import java.util.List;

public interface RoomService {

    void bookRoom(Room room);

    List<Room> showAllRoomsForHotel(int hotelId);

    List<Room> availableByDate(String checkIn, String checkOut);

    void saveRoom(Room room);

    Room getRoom(int roomId);
}
