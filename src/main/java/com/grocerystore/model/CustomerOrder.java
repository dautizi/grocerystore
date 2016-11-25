package com.grocerystore.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name="customer_order")
public class CustomerOrder {

    @Id
    @Column(name="id", unique=true, nullable=false)
    private long id;

    @Column(name = "id_shopping_cart", columnDefinition = "long default '0'")
    private long idShoppingCart;

    @Column(name = "total_items", nullable=false, columnDefinition="int default '0'")
    private int totalItems;

    @Digits(integer=10, fraction=2)
    @Column(name = "full_price", nullable = false)
    private BigDecimal fullPrice;

    @Digits(integer=10, fraction=2)
    @Column(name = "paid_price", nullable = false)
    private BigDecimal paidPrice;

    @Type(type="timestamp")
    @Column(name = "created_at", nullable=true)
    private Timestamp createdAt;
    @Transient
    private String    createdAtFormat;

    @Type(type="timestamp")
    @Column(name = "updated_at", nullable=true)
    private Timestamp updatedAt;
    @Transient
    private String    updatedAtFormat;

    @Column(name = "status", nullable=false, columnDefinition="int default '1'")
    private int status;

    @Size(max=20)
    @Column(name = "customer_ip", nullable=true)
    private String customerIp;

    @Size(max=20)
    @Column(name = "customer_proxy", nullable=true)
    private String customerProxy;

    @Column(name = "customer_id", columnDefinition="long default '0'", nullable=false)
    private long customerId;

    @ManyToOne
    @JoinColumn(name="id", referencedColumnName="id", insertable=false, updatable=false)
    private Customer customer;

    @OneToMany(mappedBy="customerOrder", targetEntity=CustomerOrderItem.class)
    private Set<CustomerOrderItem> items;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getIdShoppingCart() {
        return idShoppingCart;
    }
    public void setIdShoppingCart(long idShoppingCart) {
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
    public long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public Set<CustomerOrderItem> getItems() {
        return items;
    }
    public void setItems(Set<CustomerOrderItem> items) {
        this.items = items;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
