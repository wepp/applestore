package com.team2.store.dao.impl;

import com.team2.store.dao.IProductDao;
import com.team2.store.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Isaiev on 22.02.2016.
 */

@Repository
public class ProductDao implements IProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void update(Product product) {
        currentSession().update(product);
    }

    public void save(Product product) {
        currentSession().save(product);
    }

    public Product getProductById(int id) {
        return (Product) currentSession().get(Product.class, id);
    }

    public List<Product> getAll(Class<Product> tClass)  throws Exception{
        String fullClassName = tClass.newInstance().getClass().getName();
        fullClassName = fullClassName.substring(fullClassName.lastIndexOf(".")+1, fullClassName.length());
        return currentSession().createQuery("from "+fullClassName).list();
    }
}
