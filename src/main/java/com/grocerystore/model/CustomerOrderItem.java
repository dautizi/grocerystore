package com.grocerystore.model;

import java.math.BigDecimal;

public class CustomerOrderItem {

    private Integer idCustomerOrder;
    private Integer idItem;
    private int quantity;
    private BigDecimal fullPrice;
    private boolean discount;
    private int discountPerc;
    private BigDecimal discountPrice;
    private BigDecimal paidPrice;

    // default '1'
    private int status;

    private Item item;

    public Integer getIdCustomerOrder() {
        return idCustomerOrder;
    }
    public void setIdCustomerOrder(Integer idCustomerOrder) {
        this.idCustomerOrder = idCustomerOrder;
    }
    public Integer getIdItem() {
        return idItem;
    }
    public void setIdItem(Integer idItem) {
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

    @Override
    public String toString() {
        return "CustomerOrderItem [idCustomerOrder=" + idCustomerOrder
                + ", idItem=" + idItem + ", quantity=" + quantity
                + ", fullPrice=" + fullPrice + ", discount=" + discount
                + ", discountPerc=" + discountPerc + ", discountPrice="
                + discountPrice + ", paidPrice=" + paidPrice + ", status="
                + status + "]";
    }

}
