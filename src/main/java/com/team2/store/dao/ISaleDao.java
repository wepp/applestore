package com.team2.store.dao;

import com.team2.store.entities.Product;
import com.team2.store.entities.Sale;

import java.util.List;

/**
 * Created by Isaiev on 04.04.2016.
 */
public interface ISaleDao {

    void addSale(Sale sale);
    void update(Sale sale);
    void delete(Sale sale);
    Sale getSaleById(int id);
    List<Sale> getAll(Class<Sale> tClass) throws Exception;
}
