package com.team2.store.dao.impl;

import com.team2.store.dao.IProductDao;
import com.team2.store.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public void addProduct(Product product) {
        product.setCount(product.getCount()+1);
        currentSession().update(product);
    }

    public Product getProductById(int id) {
        return (Product) currentSession().get(Product.class, id);
    }
}
