package com.team2.store.service.impl;

import com.team2.store.dao.IUserDao;
import com.team2.store.entities.User;
import com.team2.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Isaiev on 22.02.2016.
 */
@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }
}
