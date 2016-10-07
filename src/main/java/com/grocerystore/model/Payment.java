package com.grocerystore.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Payment {

    private Integer id;
    private Integer idCustomerOrder;
    private Integer idCustomer;

    private String code;
    private String name;
    private String description;
    private BigDecimal sum;
    private BigDecimal paymentPercentage;
    private BigDecimal paymentExtra;

    private Integer idCrediCard;
    private int prg;
    private boolean paid;
    private int transactionStatus;

    private Timestamp createdAt;
    private String    createdAtFormat;

    private Timestamp updatedAt;
    private String    updatedAtFormat;

    // default '1'
    private int status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCustomerOrder() {
        return idCustomerOrder;
    }

    public void setIdCustomerOrder(Integer idCustomerOrder) {
        this.idCustomerOrder = idCustomerOrder;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getPaymentPercentage() {
        return paymentPercentage;
    }

    public void setPaymentPercentage(BigDecimal paymentPercentage) {
        this.paymentPercentage = paymentPercentage;
    }

    public BigDecimal getPaymentExtra() {
        return paymentExtra;
    }

    public void setPaymentExtra(BigDecimal paymentExtra) {
        this.paymentExtra = paymentExtra;
    }

    public Integer getIdCrediCard() {
        return idCrediCard;
    }

    public void setIdCrediCard(Integer idCrediCard) {
        this.idCrediCard = idCrediCard;
    }

    public int getPrg() {
        return prg;
    }

    public void setPrg(int prg) {
        this.prg = prg;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(int transactionStatus) {
        this.transactionStatus = transactionStatus;
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
        return "Payment [id=" + id + ", idCustomerOrder=" + idCustomerOrder
                + ", idCustomer=" + idCustomer + ", code=" + code + ", name="
                + name + ", description=" + description + ", sum=" + sum
                + ", paymentPercentage=" + paymentPercentage + ", paymentExtra="
                + paymentExtra + ", idCrediCard=" + idCrediCard + ", prg=" + prg
                + ", paid=" + paid + ", transactionStatus=" + transactionStatus
                + ", createdAt=" + createdAt + ", createdAtFormat="
                + createdAtFormat + ", updatedAt=" + updatedAt
                + ", updatedAtFormat=" + updatedAtFormat + ", status=" + status
                + "]";
    }

}
