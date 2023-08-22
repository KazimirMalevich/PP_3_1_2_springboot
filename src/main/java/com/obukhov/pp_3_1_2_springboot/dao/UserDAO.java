package com.obukhov.pp_3_1_2_springboot.dao;

import com.obukhov.pp_3_1_2_springboot.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    User deleteUser(int id);

    void update(User updateUser);
}
