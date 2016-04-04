package com.team2.store.dao;

import com.team2.store.entities.User;

/**
 * Created by Isaiev on 22.02.2016.
 */
public interface IUserDao {
    void addUser(User user);
    User getUserByLogin(String login);
    void update(User user);
    public void delete(User user);
}
