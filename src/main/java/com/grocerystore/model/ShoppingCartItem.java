package com.grocerystore.model;

import java.sql.Timestamp;

public class ShoppingCartItem {

    private Integer idShoppingCart;
    private String cartNumber;
    private Integer idItem;
    private int quantity;

    private Timestamp createdAt;
    private String    createdAtFormat;

    private Timestamp updatedAt;
    private String    updatedAtFormat;

    private Timestamp expireAt;
    private String    expireAtFormat;

    private Integer idUser;

    // default '1'
    private int status;

    public Integer getIdShoppingCart() {
        return idShoppingCart;
    }
    public void setIdShoppingCart(Integer idShoppingCart) {
        this.idShoppingCart = idShoppingCart;
    }
    public String getCartNumber() {
        return cartNumber;
    }
    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
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
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Timestamp getExpireAt() {
        return expireAt;
    }
    public void setExpireAt(Timestamp expireAt) {
        this.expireAt = expireAt;
    }
    public Integer getIdUser() {
        return idUser;
    }
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getCreatedAtFormat() {
        return createdAtFormat;
    }
    public void setCreatedAtFormat(String createdAtFormat) {
        this.createdAtFormat = createdAtFormat;
    }
    public String getUpdatedAtFormat() {
        return updatedAtFormat;
    }
    public void setUpdatedAtFormat(String updatedAtFormat) {
        this.updatedAtFormat = updatedAtFormat;
    }
    public String getExpireAtFormat() {
        return expireAtFormat;
    }
    public void setExpireAtFormat(String expireAtFormat) {
        this.expireAtFormat = expireAtFormat;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem [idShoppingCart=" + idShoppingCart
                + ", cartNumber=" + cartNumber + ", idItem=" + idItem
                + ", quantity=" + quantity + ", createdAt=" + createdAt
                + ", createdAtFormat=" + createdAtFormat + ", updatedAt="
                + updatedAt + ", updatedAtFormat=" + updatedAtFormat
                + ", expireAt=" + expireAt + ", expireAtFormat="
                + expireAtFormat + ", idUser=" + idUser + ", status=" + status
                + "]";
    }

}
