package com.grocerystore.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.mvc.Controller;

import com.grocerystore.model.configuration.Config;

public class ErrorController extends SimpleMappingExceptionResolver implements Controller {

    private String view;
    private Config config;

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Map<String, Object> model = new HashMap<String, Object>();

        Integer errorCode = new Integer(404);
        model.put("errorCode", errorCode);
        response.setStatus(errorCode);
        String finalView = this.getView();

        return new ModelAndView(finalView, model);
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

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return resolveException(request, response, null, null);
    }

}
