package org.agency.service;


import org.agency.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);

    List<User> findAllUsers();
}
