package com.team2.store.dao.impl;

import com.team2.store.dao.IProviderDao;
import com.team2.store.entities.Provider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Isaiev on 04.04.2016.
 */
@Repository
public class ProviderDao implements IProviderDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void addProvider(Provider provider) {
        currentSession().save(provider);
    }

    public void update(Provider provider) {
        currentSession().update(provider);
    }

    public void delete(Provider provider) {
        currentSession().delete(provider);
    }

    public Provider getProviderById(int id) {
        return (Provider) currentSession().get(Provider.class, id);
    }

    public List<Provider> getAll(Class<Provider> tClass) throws Exception {
        String fullClassName = tClass.newInstance().getClass().getName();
        fullClassName = fullClassName.substring(fullClassName.lastIndexOf(".")+1, fullClassName.length());
        return currentSession().createQuery("from "+fullClassName).list();
    }
}
