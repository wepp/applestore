package com.team2.store.service;

import com.team2.store.entities.Provider;

import java.util.List;

/**
 * Created by Isaiev on 04.04.2016.
 */
public interface IProviderService {

    void addProvider(Provider provider);
    void update(Provider provider);
    public void delete(Provider provider);
    Provider getProviderById(int id);
    List<Provider> getAll() throws Exception;
}
