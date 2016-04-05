package com.team2.store.service;

import com.team2.store.entities.Sale;
import com.team2.store.entities.User;

import java.util.List;

/**
 * Created by Isaiev on 22.02.2016.
 */
public interface IUserService {
    void addUser(User user);
    User login(String login, String password);
    User getUserById(int id);
    List<User> getAll() throws Exception;
}
