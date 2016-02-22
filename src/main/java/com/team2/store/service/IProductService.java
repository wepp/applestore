package com.team2.store.service;

import com.team2.store.entities.Product;

/**
 * Created by Isaiev on 22.02.2016.
 */
public interface IProductService {
    void addProduct(Product product);
    public Product getProductById(int id);
}
