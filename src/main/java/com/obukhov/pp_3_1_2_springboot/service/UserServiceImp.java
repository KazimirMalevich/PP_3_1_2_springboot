package com.obukhov.pp_3_1_2_springboot.service;

import com.obukhov.pp_3_1_2_springboot.dao.UserDAO;
import com.obukhov.pp_3_1_2_springboot.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {
    private final UserDAO userDAO;

    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public User deleteUser(int id) {
        return userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public void update(User updateUser) {
        userDAO.update(updateUser);
    }
}
