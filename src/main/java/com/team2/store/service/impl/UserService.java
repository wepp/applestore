package com.team2.store.service.impl;

import com.team2.store.dao.IUserDao;
import com.team2.store.entities.Product;
import com.team2.store.entities.User;
import com.team2.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Isaiev on 22.02.2016.
 */
@Service ("userService")
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public User login(String login, String password) {
        User user = userDao.getUserByLogin(login);
        if(user == null)
            return null;
        if(user.getPassword().equals(password))
            return user;
        return null;
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAll() throws Exception {
        return userDao.getAll(User.class);
    }
}
