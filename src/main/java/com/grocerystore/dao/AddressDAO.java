package com.grocerystore.dao;

import com.grocerystore.model.Address;

public interface AddressDAO {

    public long create(Address address);

    public Address update(Address address);

    public void delete(Address address);

    public Address getById(long id);
}
