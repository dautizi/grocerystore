package com.grocerystore.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grocerystore.dao.ItemDAO;
import com.grocerystore.model.Item;
import com.grocerystore.startup.HibernateManager;

@Repository
public class ItemDAOImpl implements ItemDAO {

    @Autowired
    private HibernateManager hibernateManager;

    public ItemDAOImpl(SessionFactory sessionFactory) {}

    @Override
    public long create(Item item) {
        return (Long) hibernateManager.create(item);
    }

    @Override
    public Item update(Item item){
        return hibernateManager.update(item);
    }

    @Override
    public void delete(Item item){
        hibernateManager.delete(item);
    }

}
