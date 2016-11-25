package com.grocerystore.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.grocerystore.ModelTestUtil;
import com.grocerystore.model.Address;
import com.grocerystore.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev-grocery")
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class AddressDAOTest extends ModelTestUtil {

    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Test
    public void createCustomerWithAddress() {
        // create a customer
        Customer customer = getNewCustomer();
        long customerId = customerDAO.create(customer);

        Customer justCreatedCustomer = customerDAO.getById(customerId);
        Assert.assertNotNull("Customer should have been created", justCreatedCustomer);

        Assert.assertNotNull("Customer should have been created first. Check the Before test. ", customer);

        // create the first address
        Address address1 = getNewAddress(customer.getId(), true, true, 1);
        long idAddress1 = addressDAO.create(address1);
        Assert.assertNotEquals(0, idAddress1);

        Address justCreatedAddress = addressDAO.getById(customerId);
        Assert.assertNotNull("Address1 should have been created", justCreatedAddress);
        Assert.assertEquals(address1.getAddress1(), justCreatedAddress.getAddress1());
        Assert.assertEquals(address1.getAddress2(), justCreatedAddress.getAddress2());
        Assert.assertEquals(address1.getCountry(), justCreatedAddress.getCountry());
        Assert.assertEquals(address1.getIdCustomer(), justCreatedAddress.getIdCustomer());
        Assert.assertEquals(address1.getLocality(), justCreatedAddress.getLocality());
        Assert.assertEquals(address1.getPostcode(), justCreatedAddress.getPostcode());
        Assert.assertEquals(address1.getProvince(), justCreatedAddress.getProvince());
        Assert.assertEquals(address1.getStatus(), justCreatedAddress.getStatus());

        // create a second address
        Address address2 = getNewAddress(customer.getId(), false, false, 1);
        long idAddress2 = addressDAO.create(address2);
        Assert.assertNotEquals(0, idAddress2);

        Address justCreatedAddress2 = addressDAO.getById(customerId);
        Assert.assertNotNull("Address2 should have been created", justCreatedAddress2);
        Assert.assertEquals(address2.getAddress1(), justCreatedAddress2.getAddress1());
        Assert.assertEquals(address2.getAddress2(), justCreatedAddress2.getAddress2());
        Assert.assertEquals(address2.getCountry(), justCreatedAddress2.getCountry());
        Assert.assertEquals(address2.getIdCustomer(), justCreatedAddress2.getIdCustomer());
        Assert.assertEquals(address2.getLocality(), justCreatedAddress2.getLocality());
        Assert.assertEquals(address2.getPostcode(), justCreatedAddress2.getPostcode());
        Assert.assertEquals(address2.getProvince(), justCreatedAddress2.getProvince());
        Assert.assertEquals(address2.getStatus(), justCreatedAddress2.getStatus());
    }

    @Test
    public void deleteCustomer() {
        // create a customer
        Customer customer = getNewCustomer();
        customerDAO.create(customer);
        Assert.assertNotNull("Customer should have been created first. Check the Before test. ", customer);
        Assert.assertNotNull(customer);
        try {
            customerDAO.delete(customer);
        } catch (Exception ex) {
            Assert.assertTrue("Customer deletion does not work. ", false);
        }
    }
}
