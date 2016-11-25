package com.grocerystore.dao;

import com.grocerystore.model.Image;

public interface ImageDAO {

    public long create(Image image);

    public Image update(Image image);

    public void delete(Image image);

    public Image getById(long id);
}
