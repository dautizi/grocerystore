package com.grocerystore.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grocerystore.dao.AddressDAO;
import com.grocerystore.model.Address;
import com.grocerystore.startup.HibernateManager;

@Repository
@Transactional
public class AddressDAOImpl implements AddressDAO {

    @Autowired
    private HibernateManager hibernateManager;

    public AddressDAOImpl(SessionFactory sessionFactory) {}

    @Override
    public long create(Address address) {
        return (Long) hibernateManager.create(address);
    }

    @Override
    public Address update(Address address){
        return hibernateManager.update(address);
    }

    @Override
    public void delete(Address address){
        hibernateManager.delete(address);
    }

    @Override
    public Address getById(long id) {
        return hibernateManager.fetchById(id, Address.class);
    }
}
