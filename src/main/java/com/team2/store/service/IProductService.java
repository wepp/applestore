package com.team2.store.service;

import com.team2.store.entities.Product;

import java.util.List;

/**
 * Created by Isaiev on 22.02.2016.
 */
public interface IProductService {
    void addOneProduct(Product product);
    public Product getProductById(int id);
    void removeOneProduct(Product product);
    void addNewProduct(Product product);
    List<Product> getAll();
    void delete(Product product);
    void update(Product product);
}
