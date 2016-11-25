package com.grocerystore.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grocerystore.dao.ItemImageDAO;
import com.grocerystore.model.ItemImage;
import com.grocerystore.startup.HibernateManager;

@Repository
@Transactional
public class ItemImageDAOImpl implements ItemImageDAO {

    @Autowired
    private HibernateManager hibernateManager;

    public ItemImageDAOImpl(SessionFactory sessionFactory) {}

    @Override
    public long create(ItemImage itemImage) {
        return (Long) hibernateManager.create(itemImage);
    }

    @Override
    public ItemImage update(ItemImage itemImage){
        return hibernateManager.update(itemImage);
    }

    @Override
    public void delete(ItemImage itemImage){
        hibernateManager.delete(itemImage);
    }

    @Override
    public ItemImage getById(long id) {
        return hibernateManager.fetchById(id, ItemImage.class);
    }
}
