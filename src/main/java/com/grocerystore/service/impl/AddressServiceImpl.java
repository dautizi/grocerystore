package com.grocerystore.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grocerystore.dao.AddressDAO;
import com.grocerystore.model.Address;
import com.grocerystore.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    protected final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Autowired
    private AddressDAO addressDAO;

    @Override
    public long create(Address address) {
        long id = 0;
        try {
            id = addressDAO.create(address);
        } catch (Exception e) {
            logger.error("Error " + e);
        }
        return id;
    }

    @Override
    public Address update(Address address) {
        return addressDAO.update(address);
    }

    @Override
    public void delete(Address address) {
        addressDAO.delete(address);
    }

    @Override
    public Address getById(long id) {
        return addressDAO.getById(id);
    }
}
