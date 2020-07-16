package org.agency.controller;

import org.agency.entity.Order;
import org.agency.entity.Room;
import org.agency.entity.User;
import org.agency.service.HotelService;
import org.agency.service.OrderService;
import org.agency.service.RoomService;
import org.agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @Autowired
    HotelService hotelService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @GetMapping("/showRooms")
    public String showRooms(@RequestParam("hotelId") int hotelId, Model model) {
        List<Room> rooms = roomService.showAllRoomsForHotel(hotelId);
        model.addAttribute("rooms", rooms);
        return "room-list";
    }

    @GetMapping("/addRoom")
    public String addRoom(@RequestParam("hotelId") int hotelId, Model model) {
        Room room = new Room();
        room.setHotel(hotelService.getHotel(hotelId));
        model.addAttribute("room", room);

        return "room-save";
    }

    @PostMapping("/saveRoom")
    public String saveRoom(@Valid @ModelAttribute("room") Room room, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "room-save";
        } else {
            roomService.saveRoom(room);
            return "redirect:/hotel/list";
        }
    }

    @GetMapping("/bookRoom")
    public String bookRoom(@RequestParam("roomId") int roomId, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        Order order = new Order();
        User user = userService.findByUserName(username);
        order.setRoom(roomService.getRoom(roomId));
        order.setUser(user);
        model.addAttribute("order", order);
        return "room-book";
    }

    @PostMapping("/saveRoomBook")
    public String saveRoomBook(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "room-book";
        } else {
            orderService.saveOrder(order);
            return "redirect:/hotel/list";
        }
    }
}
