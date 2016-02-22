package com.team2.store.service;

import com.team2.store.entities.Product;

/**
 * Created by Isaiev on 22.02.2016.
 */
public interface IProductService {
    void addOneProduct(Product product);
    public Product getProductById(int id);
    void removeOneProduct(Product product);
    void addNewProduct(Product product);
}
