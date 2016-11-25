package com.grocerystore.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grocerystore.dao.ImageDAO;
import com.grocerystore.model.Image;
import com.grocerystore.service.ImageService;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    protected final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    private ImageDAO imageDAO;

    @Override
    public long create(Image image) {
        long id = 0;
        try {
            id = imageDAO.create(image);
        } catch (Exception e) {
            logger.error("Error " + e);
        }
        return id;
    }

    @Override
    public Image update(Image image) {
        return imageDAO.update(image);
    }

    @Override
    public void delete(Image image) {
        imageDAO.delete(image);
    }

    @Override
    public Image getById(long id) {
        Image image = null;
        try {
            image = imageDAO.getById(id);
        } catch (Exception e) {
            logger.error("Error " + e);
        }
        return image;
    }
}
