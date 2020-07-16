package org.agency.dao;

import org.agency.entity.Hotel;

import java.util.List;

public interface HotelDAO {
    List<Hotel> getHotels();

    void saveHotel(Hotel hotel);

    List<Hotel> searchHotelByCountry(String countryName);

    Hotel getHotel(int hotelId);
}
