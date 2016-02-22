package com.team2.store.dao;

import com.team2.store.entities.Product;

/**
 * Created by Isaiev on 22.02.2016.
 */
public interface IProductDao {
    void update(Product product);
    void save(Product product);
    Product getProductById(int id);
}
