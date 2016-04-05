package com.team2.store.dao;

import com.team2.store.entities.User;

import java.util.List;

/**
 * Created by Isaiev on 22.02.2016.
 */
public interface IUserDao {
    void addUser(User user);
    User getUserByLogin(String login);
    void update(User user);
    public void delete(User user);
    List<User> getAll(Class<User> tClass) throws Exception;
    User getUserById(int id);
}
