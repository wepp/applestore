package com.team2.store.service.impl;

import com.team2.store.dao.ISaleDao;
import com.team2.store.entities.Product;
import com.team2.store.entities.Sale;
import com.team2.store.service.IProductService;
import com.team2.store.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Isaiev on 04.04.2016.
 */
@Service
@Transactional
public class SaleService implements ISaleService {

    @Autowired
    private ISaleDao saleDao;
    @Autowired
    private IProductService productService;

    public void addSale(Sale sale) {
        Product product = productService.getProductById(sale.getProduct().getProduct_id());
        product.setCount(product.getCount() - sale.getCount());
        saleDao.addSale(sale);
        productService.update(product);
    }

    public void update(Sale sale) {
        saleDao.update(sale);
    }

    public void delete(Sale sale) {
        Product product = productService.getProductById(sale.getProduct().getProduct_id());
        product.setCount(product.getCount() + sale.getCount());
        saleDao.addSale(sale);
        saleDao.delete(sale);
    }

    public Sale getSaleById(int id) {
        return saleDao.getSaleById(id);
    }

    public List<Sale> getAll() throws Exception {
        return saleDao.getAll(Sale.class);
    }
}
