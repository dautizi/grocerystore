package com.grocerystore.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grocerystore.dao.CustomerDAO;
import com.grocerystore.model.Customer;
import com.grocerystore.startup.HibernateManager;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private HibernateManager hibernateManager;

    public CustomerDAOImpl(SessionFactory sessionFactory) {}

    @Override
    public long create(Customer customer) {
        return (Long) hibernateManager.create(customer);
    }

    @Override
    public Customer update(Customer customer){
        return hibernateManager.update(customer);
    }

    @Override
    public void delete(Customer customer){
        hibernateManager.delete(customer);
    }

    @Override
    public Customer getById(long id) {
        return hibernateManager.fetchById(id, Customer.class);
    }
}
