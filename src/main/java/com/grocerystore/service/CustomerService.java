package com.grocerystore.service;

import com.grocerystore.model.Customer;

public interface CustomerService {

    public long create(Customer customer);

    public Customer update(Customer customer);

    public void delete(Customer customer);

    public Customer getById(long id);
}
