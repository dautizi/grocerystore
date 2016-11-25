package com.grocerystore.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;

@Entity
@Table(name="customer_order_item")
public class CustomerOrderItem {

    @Id
    @Column(name="id", unique=true, nullable=false)
    private Integer idCustomerOrder;

    @Column(name = "id_item", columnDefinition = "long default '0'")
    private long idItem;

    @Column(name = "quantity", nullable=false, columnDefinition="int default '0'")
    private int quantity;

    @Digits(integer=10, fraction=2)
    @Column(name = "full_price", nullable=false)
    private BigDecimal fullPrice;

    @Column(name = "discount", columnDefinition = "boolean default false", nullable=false)
    private boolean discount;

    @Column(name = "discount_perc", nullable=false, columnDefinition="int default '1'")
    private int discountPerc;

    @Digits(integer=10, fraction=2)
    @Column(name = "discount_price", nullable=true)
    private BigDecimal discountPrice;

    @Digits(integer=10, fraction=2)
    @Column(name = "paid_price", nullable=false)
    private BigDecimal paidPrice;

    @Column(name = "status", nullable=false, columnDefinition="int default '1'")
    private int status;

    @ManyToOne
    @JoinColumn(name="id", referencedColumnName="id", insertable=false, updatable=false)
    private CustomerOrder customerOrder;

    @Transient
    private Item item;

    public Integer getIdCustomerOrder() {
        return idCustomerOrder;
    }
    public void setIdCustomerOrder(Integer idCustomerOrder) {
        this.idCustomerOrder = idCustomerOrder;
    }
    public long getIdItem() {
        return idItem;
    }
    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getFullPrice() {
        return fullPrice;
    }
    public void setFullPrice(BigDecimal fullPrice) {
        this.fullPrice = fullPrice;
    }
    public boolean isDiscount() {
        return discount;
    }
    public void setDiscount(boolean discount) {
        this.discount = discount;
    }
    public int getDiscountPerc() {
        return discountPerc;
    }
    public void setDiscountPerc(int discountPerc) {
        this.discountPerc = discountPerc;
    }
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }
    public BigDecimal getPaidPrice() {
        return paidPrice;
    }
    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }
    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

}
