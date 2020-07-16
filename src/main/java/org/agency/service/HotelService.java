package org.agency.service;

import org.agency.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getHotels();

    void saveHotel(Hotel hotel);

    List<Hotel> searchHotelByCountry(String countryName);

    Hotel getHotel(int hotelId);
}
