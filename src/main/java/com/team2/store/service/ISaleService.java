package com.team2.store.service;

import com.team2.store.entities.Product;
import com.team2.store.entities.Sale;

import java.util.List;

/**
 * Created by Isaiev on 04.04.2016.
 */
public interface ISaleService {

    void addSale(Sale sale);
    void update(Sale sale);
    public void delete(Sale sale);
    Sale getSaleById(int id);
    List<Sale> getAll() throws Exception;
}
