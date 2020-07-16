package org.agency.dao;

import org.agency.entity.User;

import java.util.List;

public interface UserDAO {

    User findByUserName(String userName);

    List<User> findAllUsers();

}
