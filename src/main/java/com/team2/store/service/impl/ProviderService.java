package com.team2.store.service.impl;

import com.team2.store.dao.IProviderDao;
import com.team2.store.entities.Provider;
import com.team2.store.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Isaiev on 04.04.2016.
 */
@Service
@Transactional
public class ProviderService implements IProviderService{

    @Autowired
    private IProviderDao providerDao;


    public void addProvider(Provider provider) {
        providerDao.addProvider(provider);
    }

    public void update(Provider provider) {
        providerDao.update(provider);
    }

    public void delete(Provider provider) {
        providerDao.delete(provider);
    }

    public Provider getProviderById(int id) {
        return providerDao.getProviderById(id);
    }

    public List<Provider> getAll() throws Exception {
        return providerDao.getAll(Provider.class);
    }
}
