package com.grocerystore.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.grocerystore.ModelTestUtil;
import com.grocerystore.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev-grocery")
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class CustomerDAOTest extends ModelTestUtil {

    @Autowired
    private CustomerDAO customerDAO;

    private long customerId = 0;

    @Test
    public void createCustomerWithoutAddress() {
        // create a customer
        Customer customer = getNewCustomer();
        customerId = customerDAO.create(customer);

        Customer justCreatedCustomer = customerDAO.getById(customerId);
        Assert.assertNotNull("Customer should have been created", justCreatedCustomer);
        Assert.assertEquals(customer.getEmail(), justCreatedCustomer.getEmail());
        Assert.assertEquals(customer.getAge(), justCreatedCustomer.getAge());
        Assert.assertEquals(customer.getBirthCountry(), justCreatedCustomer.getBirthCountry());
        Assert.assertEquals(customer.getBirthLocation(), justCreatedCustomer.getBirthLocation());
        Assert.assertEquals(customer.getBirthmonth(), justCreatedCustomer.getBirthmonth());
        Assert.assertEquals(customer.getBirthday(), justCreatedCustomer.getBirthday());
        Assert.assertEquals(customer.getBirthyear(), justCreatedCustomer.getBirthyear());
        Assert.assertEquals(customer.getCountry(), justCreatedCustomer.getCountry());
        Assert.assertTrue(justCreatedCustomer.getEmailVerification());
        Assert.assertEquals(customer.getName(), justCreatedCustomer.getName());
        Assert.assertEquals(customer.getPassword(), justCreatedCustomer.getPassword());
        Assert.assertEquals(customer.getSurname(), justCreatedCustomer.getSurname());
        Assert.assertEquals(customer.getStatus(), justCreatedCustomer.getStatus());
        Assert.assertEquals(customer.getUsername(), justCreatedCustomer.getUsername());
        Assert.assertEquals(customer.getVisits(), justCreatedCustomer.getVisits());
    }

    @Test
    public void deleteCustomer() {
        Assert.assertNotEquals("A customer should be created first.", 0, customerId);
        Customer customer = customerDAO.getById(customerId);
        Assert.assertNotNull(customer);
        try {
            customerDAO.delete(customer);
        } catch (Exception ex) {
            Assert.assertTrue("Customer deletion does not work. ", false);
        }
    }

}
