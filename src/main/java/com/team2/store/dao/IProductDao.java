package com.team2.store.dao;

import com.team2.store.entities.Product;

import java.util.List;

/**
 * Created by Isaiev on 22.02.2016.
 */
public interface IProductDao {
    void update(Product product);
    void save(Product product);
    Product getProductById(int id);
    List<Product> getAll(Class<Product> tClass) throws Exception;
}
