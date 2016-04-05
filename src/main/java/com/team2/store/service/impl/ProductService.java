package com.team2.store.service.impl;

import com.team2.store.dao.IProductDao;
import com.team2.store.entities.Product;
import com.team2.store.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Isaiev on 22.02.2016.
 */
@Service ("productService")
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private IProductDao productDao;

    public void addOneProduct(Product product) {
        product.setCount(product.getCount()+1);
        productDao.update(product);
    }

    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    public void removeOneProduct(Product product) {
        product.setCount(product.getCount()-1);
        productDao.update(product);
    }

    public void addNewProduct(Product product) {
        productDao.save(product);
    }

    public List<Product> getAll(){
        try {
            return productDao.getAll(Product.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Product product) {
        productDao.delete(product);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }
}
