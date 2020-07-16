package org.agency.controller;

import org.agency.entity.Order;
import org.agency.entity.User;
import org.agency.service.OrderService;
import org.agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/management")
public class ManagementController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @GetMapping("/showUsers")
    public String showUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);

        return "user-list";
    }

    @GetMapping("/showOrders")
    public String showOrdersForUser(@RequestParam("userId") int userId,Model model) {
        List<Order> ordersForUser = orderService.showOrdersForUser(userId);
        model.addAttribute("orders", ordersForUser);
        return "order-list";
    }

    @GetMapping("/home")
    public String showManagementHomePage() {

        return "management-home";
    }


}
