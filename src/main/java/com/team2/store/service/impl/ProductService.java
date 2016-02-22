package com.team2.store.service.impl;

import com.team2.store.dao.IProductDao;
import com.team2.store.entities.Product;
import com.team2.store.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Isaiev on 22.02.2016.
 */
@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private IProductDao productDao;

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }
}
