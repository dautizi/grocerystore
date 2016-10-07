package com.grocerystore.dao;

import com.grocerystore.model.Item;

public interface ItemDAO {

    public long create(Item item);

    public Item update(Item item);

    public void delete(Item item);

}
