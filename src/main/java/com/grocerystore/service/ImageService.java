package com.grocerystore.service;

import com.grocerystore.model.Image;

public interface ImageService {

    public long create(Image image);

    public Image update(Image image);

    public void delete(Image image);

    public Image getById(long id);
}
