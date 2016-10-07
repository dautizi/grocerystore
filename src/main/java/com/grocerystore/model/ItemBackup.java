package com.grocerystore.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class ItemBackup implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String title;
    private String cover;
    private String nutritionalImage;

    // default '1'
    private int availability;

    // datetime DEFAULT NULL
    private Timestamp nextAvailability;
    private String nextAvailabilityFormat;

    private BigDecimal fullPrice;

    // default false
    private boolean discount;
    private int discountPercentage;
    private BigDecimal discountPrice;

    private Timestamp discountFrom;
    private String    discountFromFormat;
    
    private Timestamp discountTo;
    private String    discountToFormat;

    private Timestamp createdAt;
    private String    createdAtFormat;
    
    private Timestamp updatedAt;
    private String    updatedAtFormat;

    // default '1'
    private int status;
    private String tag;

    private List<ItemImage> images;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    public String getNutritionalImage() {
        return nutritionalImage;
    }
    public void setNutritionalImage(String nutritionalImage) {
        this.nutritionalImage = nutritionalImage;
    }
    public int getAvailability() {
        return availability;
    }
    public void setAvailability(int availability) {
        this.availability = availability;
    }
    public Timestamp getNextAvailability() {
        return nextAvailability;
    }
    public void setNextAvailability(Timestamp nextAvailability) {
        this.nextAvailability = nextAvailability;
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
    public int getDiscountPercentage() {
        return discountPercentage;
    }
    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }
    public Timestamp getDiscountFrom() {
        return discountFrom;
    }
    public void setDiscountFrom(Timestamp discountFrom) {
        this.discountFrom = discountFrom;
    }
    public Timestamp getDiscountTo() {
        return discountTo;
    }
    public void setDiscountTo(Timestamp discountTo) {
        this.discountTo = discountTo;
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
    public void setUpdated_at(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public List<ItemImage> getImages() {
        return images;
    }
    public void setImages(List<ItemImage> images) {
        this.images = images;
    }
    public String getDiscountFromFormat() {
        return discountFromFormat;
    }
    public void setDiscountFromFormat(String discountFromFormat) {
        this.discountFromFormat = discountFromFormat;
    }
    public String getDiscountToFormat() {
        return discountToFormat;
    }
    public void setDiscountToFormat(String discountToFormat) {
        this.discountToFormat = discountToFormat;
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
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", title=" + title
                + ", cover=" + cover + ", nutritionalImage=" + nutritionalImage
                + ", availability=" + availability + ", nextAvailability="
                + nextAvailability + ", nextAvailabilityFormat="
                + nextAvailabilityFormat + ", fullPrice=" + fullPrice
                + ", discount=" + discount + ", discountPercentage="
                + discountPercentage + ", discountPrice=" + discountPrice
                + ", discountFrom=" + discountFrom + ", discountFromFormat="
                + discountFromFormat + ", discountTo=" + discountTo
                + ", discountToFormat=" + discountToFormat + ", createdAt="
                + createdAt + ", createdAtFormat=" + createdAtFormat
                + ", updatedAt=" + updatedAt + ", updatedAtFormat="
                + updatedAtFormat + ", status=" + status + ", tag=" + tag
                + ", images=" + images + "]";
    }

}
