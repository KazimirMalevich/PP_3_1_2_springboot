package com.obukhov.pp_3_1_2_springboot.dao;

import com.obukhov.pp_3_1_2_springboot.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User deleteUser(int id) throws NullPointerException {
        User user = getUser(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        return user;
    }

    @Override
    public void update(User updateUser) {
        entityManager.merge(updateUser);
    }
}
