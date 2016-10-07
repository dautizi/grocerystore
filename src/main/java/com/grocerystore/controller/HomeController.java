package com.grocerystore.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.grocerystore.model.Item;
import com.grocerystore.model.configuration.Config;
import com.grocerystore.service.ItemService;

public class HomeController implements Controller {

    protected final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ItemService itemService;

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
        item.setDiscount(false);
        item.setAvailability(1);
        long id = itemService.create(item);

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
