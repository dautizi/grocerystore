package com.grocerystore.dao;

import com.grocerystore.model.ItemImage;

public interface ItemImageDAO {

    public long create(ItemImage itemImage);

    public ItemImage update(ItemImage itemImage);

    public void delete(ItemImage itemImage);

    public ItemImage getById(long id);
}
