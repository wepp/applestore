package com.team2.store.dao.impl;

import com.team2.store.dao.IUserDao;
import com.team2.store.entities.Product;
import com.team2.store.entities.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public User getUserByLogin(String login) {
        Query query = currentSession().createSQLQuery(
                "select * from user where login = :login")
                .addEntity(User.class)
                .setParameter("login", login);
        List result = query.list();
        if(result!=null && !result.isEmpty())
            return (User) result.iterator().next();
        else
            return null;
    }

    public void update(User user) {
        currentSession().update(user);
    }

    public void delete(User user) {
        currentSession().delete(user);
    }

    @Override
    public List<User> getAll(Class<User> tClass) throws Exception {
        String fullClassName = tClass.newInstance().getClass().getName();
        fullClassName = fullClassName.substring(fullClassName.lastIndexOf(".")+1, fullClassName.length());
        return currentSession().createQuery("from "+fullClassName).list();
    }

    @Override
    public User getUserById(int id) {
        return (User) currentSession().get(User.class, id);
    }
}
