package com.grocerystore.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class CustomerOrder {

    private Integer id;
    private Integer idShoppingCart;
    private int totalItems;
    private BigDecimal fullPrice;
    private BigDecimal paidPrice;

    private Timestamp createdAt;
    private String    createdAtFormat;

    private Timestamp updatedAt;
    private String    updatedAtFormat;

    // default '1'
    private int status;

    private String customerIp;
    private String customerProxy;
    private Integer customerId;

    private List<CustomerOrderItem> items;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdShoppingCart() {
        return idShoppingCart;
    }
    public void setIdShoppingCart(Integer idShoppingCart) {
        this.idShoppingCart = idShoppingCart;
    }
    public int getTotalItems() {
        return totalItems;
    }
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
    public BigDecimal getFullPrice() {
        return fullPrice;
    }
    public void setFullPrice(BigDecimal fullPrice) {
        this.fullPrice = fullPrice;
    }
    public BigDecimal getPaidPrice() {
        return paidPrice;
    }
    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public String getCreatedAtFormat() {
        return createdAtFormat;
    }
    public void setCreatedAtFormat(String createdAtFormat) {
        this.createdAtFormat = createdAtFormat;
    }
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getUpdatedAtFormat() {
        return updatedAtFormat;
    }
    public void setUpdatedAtFormat(String updatedAtFormat) {
        this.updatedAtFormat = updatedAtFormat;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
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
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public List<CustomerOrderItem> getItems() {
        return items;
    }
    public void setItems(List<CustomerOrderItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CustomerOrder [id=" + id + ", idShoppingCart=" + idShoppingCart
                + ", totalItems=" + totalItems + ", fullPrice=" + fullPrice
                + ", paidPrice=" + paidPrice + ", createdAt=" + createdAt
                + ", createdAtFormat=" + createdAtFormat + ", updatedAt="
                + updatedAt + ", updatedAtFormat=" + updatedAtFormat
                + ", status=" + status + ", customerIp=" + customerIp
                + ", customerProxy=" + customerProxy + ", customerId="
                + customerId + ", items=" + items + "]";
    }

}
