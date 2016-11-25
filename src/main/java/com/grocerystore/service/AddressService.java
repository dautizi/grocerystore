package com.grocerystore.service;

import com.grocerystore.model.Address;

public interface AddressService {

    public long create(Address address);

    public Address update(Address address);

    public void delete(Address address);

    public Address getById(long id);
}
