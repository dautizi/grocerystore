package com.grocerystore.service;

import com.grocerystore.model.Item;

public interface ItemService {

    public long create(Item item);

    public Item update(Item item);

    public void delete(Item item);

    public Item getById(long id);
}
