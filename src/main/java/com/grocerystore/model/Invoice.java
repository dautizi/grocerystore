package com.grocerystore.model;

import java.sql.Timestamp;

public class Invoice {

    private Integer id;
    private Integer idCustomer;
    private Integer idCustomerOrder;
    private Integer idShipping;
    private Integer idAddress;
    private Integer idPayment;

    private Timestamp createdAt;
    private String    createdAtFormat;

    private Timestamp updatedAt;
    private String    updatedAtFormat;

    private int status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdCustomerOrder() {
        return idCustomerOrder;
    }

    public void setIdCustomerOrder(Integer idCustomerOrder) {
        this.idCustomerOrder = idCustomerOrder;
    }

    public Integer getIdShipping() {
        return idShipping;
    }

    public void setIdShipping(Integer idShipping) {
        this.idShipping = idShipping;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
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

    @Override
    public String toString() {
        return "Invoice [id=" + id + ", idCustomer=" + idCustomer
                + ", idCustomerOrder=" + idCustomerOrder + ", idShipping="
                + idShipping + ", idAddress=" + idAddress + ", idPayment="
                + idPayment + ", createdAt=" + createdAt + ", createdAtFormat="
                + createdAtFormat + ", updatedAt=" + updatedAt
                + ", updatedAtFormat=" + updatedAtFormat + ", status=" + status
                + "]";
    }

}
