package com.grocerystore.model;

import java.sql.Timestamp;
import java.util.List;

public class ShoppingCart {

    private Integer id;
    private String cartNumber;
    private String jsessionId;

    private Timestamp createdAt;
    private String    createdAtFormat;

    private Timestamp expireAt;
    private String    expireAtFormat;

    private Integer customerId;

    // datetime DEFAULT NULL
    private String customerIp;
    private String customerProxy;

    // default '1'
    private int status;

    private List<Item> items;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCartNumber() {
        return cartNumber;
    }
    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }
    public String getJsessionId() {
        return jsessionId;
    }
    public void setJsessionId(String jsessionId) {
        this.jsessionId = jsessionId;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public Timestamp getExpireAt() {
        return expireAt;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public String getCustomerIp() {
        return customerIp;
    }
    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }
    public String getCustomerProxy() {
        return customerProxy;
    }
    public void setCustomerProxy(String customerProxy) {
        this.customerProxy = customerProxy;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public String getCreatedAtFormat() {
        return createdAtFormat;
    }
    public void setCreatedAtFormat(String createdAtFormat) {
        this.createdAtFormat = createdAtFormat;
    }
    public String getExpireAtFormat() {
        return expireAtFormat;
    }
    public void setExpireAtFormat(String expireAtFormat) {
        this.expireAtFormat = expireAtFormat;
    }
    public void setExpireAt(Timestamp expireAt) {
        this.expireAt = expireAt;
    }

    @Override
    public String toString() {
        return "ShoppingCart [id=" + id + ", cartNumber=" + cartNumber
                + ", jsessionId=" + jsessionId + ", createdAt=" + createdAt
                + ", createdAtFormat=" + createdAtFormat + ", expireAt="
                + expireAt + ", expireAtFormat=" + expireAtFormat
                + ", customerId=" + customerId + ", customerIp=" + customerIp
                + ", customerProxy=" + customerProxy + ", status=" + status
                + ", items=" + items + "]";
    }

}
