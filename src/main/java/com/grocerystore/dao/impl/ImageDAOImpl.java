package com.grocerystore.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grocerystore.dao.ImageDAO;
import com.grocerystore.model.Image;
import com.grocerystore.startup.HibernateManager;

@Repository
@Transactional
public class ImageDAOImpl implements ImageDAO {

    @Autowired
    private HibernateManager hibernateManager;

    public ImageDAOImpl(SessionFactory sessionFactory) {}

    @Override
    public long create(Image image) {
        return (Long) hibernateManager.create(image);
    }

    @Override
    public Image update(Image image){
        return hibernateManager.update(image);
    }

    @Override
    public void delete(Image image){
        hibernateManager.delete(image);
    }

    @Override
    public Image getById(long id) {
        return hibernateManager.fetchById(id, Image.class);
    }
}
