package com.team2.store.dao;

import com.team2.store.entities.Provider;
import com.team2.store.entities.Sale;

import java.util.List;

/**
 * Created by Isaiev on 04.04.2016.
 */
public interface IProviderDao {

    void addProvider(Provider provider);
    void update(Provider provider);
    public void delete(Provider provider);
    Provider getProviderById(int id);
    List<Provider> getAll(Class<Provider> tClass) throws Exception;
}
