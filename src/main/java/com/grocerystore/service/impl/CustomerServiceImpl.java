package com.grocerystore.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grocerystore.dao.CustomerDAO;
import com.grocerystore.model.Customer;
import com.grocerystore.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    protected final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public long create(Customer customer) {
        long id = 0;
        try {
            id = customerDAO.create(customer);
        } catch (Exception e) {
            logger.error("Error " + e);
        }
        return id;
    }

    @Override
    public Customer update(Customer customer) {
        return customerDAO.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerDAO.delete(customer);
    }

    @Override
    public Customer getById(long id) {
        Customer customer = null;
        try {
            customer = customerDAO.getById(id);
        } catch (Exception e) {
            logger.error("Error " + e);
        }
        return customer;
    }
}
