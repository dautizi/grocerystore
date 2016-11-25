package com.grocerystore.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.grocerystore.model.Address;
import com.grocerystore.model.Customer;
import com.grocerystore.model.Item;
import com.grocerystore.model.configuration.Config;
import com.grocerystore.service.AddressService;
import com.grocerystore.service.CustomerService;
import com.grocerystore.service.ItemService;

public class HomeController implements Controller {

    protected final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    private String view;
    private Config config;

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();

        logger.info(" ###### HOME [BEGIN] ###### ");

        // update datetime
        long updateTime = (new Date()).getTime();
        model.put("param", Locale.ITALY);

        Item item = new Item();
        item.setName("first product");
        item.setStatus(1);
        item.setTitle("Vegetables");
        item.setAvailability(1);
        long id = itemService.create(item);

        // create a customer
        Customer customer = new Customer();
        customer.setEmail("dj.skav@gmail.com");
        customer.setAge(34);
        customer.setBirthCountry("Italy");
        customer.setBirthLocation("Rieti");
        customer.setBirthmonth(10);
        customer.setBirthday(6);
        customer.setBirthyear(1982);
        customer.setCountry("Sweden");
        customer.setEmailVerification(true);
        customer.setName("Daniele");
        customer.setPassword("123456789");
        customer.setSurname("Autizi");
        customer.setStatus(1);
        customer.setUsername("djskav");
        customer.setVisits(0);
        long customerId = customerService.create(customer);
        logger.info("Customer id created: "+customerId);

        // create an address
        Address address1 = new Address();
        address1.setAddress1("Birger Jarlsgatan 104 L");
        address1.setAddressType(1);
        address1.setCountry("Sweden");
        address1.setCustomerDefault(true);
        address1.setIdCustomer(customerId);
        address1.setLocality("Stockholm");
        address1.setPostcode("11420");
        address1.setPrg(1);
        address1.setProvince("Stockholm");
        address1.setSameAddress(true);
        address1.setStatus(1);
        addressService.create(address1);

        // create a second address
        Address address2 = new Address();
        address2.setAddress1("Via Immaginetta 2");
        address2.setAddressType(1);
        address2.setCountry("Italy");
        address2.setCustomerDefault(false);
        address2.setIdCustomer(customerId);
        address2.setLocality("Monte San Giovanni in Sabina");
        address2.setPostcode("02040");
        address2.setPrg(1);
        address2.setProvince("Rieti");
        address2.setSameAddress(true);
        address2.setStatus(1);
        addressService.create(address2);

        
        Customer customerX = customerService.getById(customerId);
        Set<Address> addresses = customerX.getAddresses();
        if (addresses != null) {
            logger.info(addresses.size() + " Addresses found for the customer " + customerId);
        } else {
            logger.info("No addresses found for the customer " + customerId);
        }
        
        
        ModelAndView mandv = new ModelAndView(this.getView(), model);

        logger.info(" ###### HOME [END] ###### ");

        return mandv;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

}
