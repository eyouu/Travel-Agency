package org.agency.controller;

import org.agency.entity.Hotel;
import org.agency.entity.Room;
import org.agency.service.HotelService;
import org.agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String showHotelList(Model model) {
        List<Hotel> hotels = hotelService.getHotels();
        model.addAttribute("hotelList", hotels);
        return "hotel-list";
    }

    @GetMapping("/searchHotel")
    public String searchHotel(@RequestParam("countryName") String countryName, Model model) {
        List<Hotel> foundHotels = hotelService.searchHotelByCountry(countryName);
        model.addAttribute("hotelList", foundHotels);
        return "hotel-list";
    }

    @GetMapping("/availableByDate")
    public String searchRoomByDate(@RequestParam("checkIn") String checkIn,
                                   @RequestParam("checkOut") String checkOut,
                                   Model model) {
        LocalDate checkInDate = LocalDate.parse(checkIn);
        LocalDate checkOutDate = LocalDate.parse(checkOut);
        if (checkInDate.isAfter(checkOutDate) || checkInDate.equals(checkOutDate)) {
            throw new RuntimeException();
        }

        List<Room> rooms = roomService.availableByDate(checkIn, checkOut);
        model.addAttribute("rooms", rooms);
        return "room-list";
    }

    @GetMapping("/saveHotelForm")
    public String saveHotelForm(Model model) {
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);

        return "hotel-save";
    }

    @PostMapping("/saveHotel")
    public String saveHotel(@Valid @ModelAttribute("hotel") Hotel hotel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "hotel-save";
        } else {
            hotelService.saveHotel(hotel);
            return "redirect:/hotel/list";
        }
    }

}
