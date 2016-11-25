package com.grocerystore.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grocerystore.dao.ItemDAO;
import com.grocerystore.model.Item;
import com.grocerystore.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    protected final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemDAO itemDAO;

    @Override
    public long create(Item item) {
        long id = 0;
        try {
            id = itemDAO.create(item);
        } catch (Exception e) {
            logger.error("Error " + e);
        }
        return id;
    }

    @Override
    public Item update(Item item) {
        return itemDAO.update(item);
    }

    @Override
    public void delete(Item item) {
        itemDAO.delete(item);
    }

    @Override
    public Item getById(long id) {
        Item item = null;
        try {
            item = itemDAO.getById(id);
        } catch (Exception e) {
            logger.error("Error " + e);
        }
        return item;
    }
}
