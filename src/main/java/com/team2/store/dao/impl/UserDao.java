package com.team2.store.dao.impl;

import com.team2.store.dao.IUserDao;
import com.team2.store.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Isaiev on 22.02.2016.
 */
@Repository
public class UserDao implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void addUser(User user) {
        currentSession().save(user);
    }
}
