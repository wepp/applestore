package com.team2.store.dao.impl;

import com.team2.store.dao.ISaleDao;
import com.team2.store.entities.Product;
import com.team2.store.entities.Sale;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Isaiev on 04.04.2016.
 */

@Repository
public class SaleDao implements ISaleDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void addSale(Sale sale) {
        currentSession().save(sale);
    }

    public void update(Sale sale) {
        currentSession().update(sale);
    }

    public void delete(Sale sale) {
        currentSession().delete(sale);
    }

    public Sale getSaleById(int id) {
        return (Sale) currentSession().get(Sale.class, id);
    }

    public List<Sale> getAll(Class<Sale> tClass) throws Exception{
        String fullClassName = tClass.newInstance().getClass().getName();
        fullClassName = fullClassName.substring(fullClassName.lastIndexOf(".")+1, fullClassName.length());
        return currentSession().createQuery("from "+fullClassName).list();
    }
}
