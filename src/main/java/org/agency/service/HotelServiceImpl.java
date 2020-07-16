package org.agency.service;

import org.agency.dao.HotelDAO;
import org.agency.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelDAO hotelDAO;

    @Override
    @Transactional
    public List<Hotel> getHotels() {
        return hotelDAO.getHotels();
    }

    @Override
    @Transactional
    public void saveHotel(Hotel hotel) {
        hotelDAO.saveHotel(hotel);
    }

    @Override
    @Transactional
    public List<Hotel> searchHotelByCountry(String countryName) {
        return hotelDAO.searchHotelByCountry(countryName);
    }

    @Override
    @Transactional
    public Hotel getHotel(int hotelId) {
        return hotelDAO.getHotel(hotelId);
    }
}
