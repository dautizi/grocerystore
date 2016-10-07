package com.grocerystore.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name="item")
public class Item implements Serializable {

    private static final long serialVersionUID = -7988799579036225137L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min=3, max=50)
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min=3, max=20)
    @Column(name = "title", nullable = false)
    private String title;

    @Size(max=200)
    @Column(name = "cover", nullable = true)
    private String cover;

    @Size(max=200)
    @Column(name = "nutritional_image", nullable = true)
    private String nutritionalImage;

    // default '1'
    @Column(name = "availability", nullable = false, columnDefinition="int default '1'")
    private int availability;

    // datetime DEFAULT NULL
    @Type(type="timestamp")
    @Column(name = "next_availability", nullable = true)
    private Timestamp nextAvailability;
    @Transient
    private String nextAvailabilityFormat;

    @Digits(integer=10, fraction=2)
    @Column(name = "full_price", nullable = false)
    private BigDecimal fullPrice;

    // default false
    @Column(name = "discount", columnDefinition = "boolean default false", nullable = false)
    private boolean discount;

    @Column(name = "discount_perc", nullable = false, columnDefinition="int default '1'")
    private int discountPercentage;

    @Digits(integer=10, fraction=2)
    @Column(name = "discount_price", nullable = false)
    private BigDecimal discountPrice;

    @Type(type="timestamp")
    @Column(name = "discount_from", nullable = true)
    private Timestamp discountFrom;
    @Transient
    private String    discountFromFormat;

    @Type(type="timestamp")
    @Column(name = "discount_to", nullable = true)
    private Timestamp discountTo;
    @Transient
    private String    discountToFormat;

    @Type(type="timestamp")
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Transient
    private String    createdAtFormat;

    @Type(type="timestamp")
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Transient
    private String    updatedAtFormat;

    // default '1'
    @Column(name = "status", nullable = false, columnDefinition="int default '1'")
    private int status;

    @Size(max=200)
    @Column(name = "tag", nullable = true)
    private String tag;

    @Transient
    private List<ItemImage> images;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Item))
            return false;
        Item other = (Item) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getNextAvailabilityFormat() {
        return nextAvailabilityFormat;
    }

    public void setNextAvailabilityFormat(String nextAvailabilityFormat) {
        this.nextAvailabilityFormat = nextAvailabilityFormat;
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

    public String getDiscountFromFormat() {
        return discountFromFormat;
    }

    public void setDiscountFromFormat(String discountFromFormat) {
        this.discountFromFormat = discountFromFormat;
    }

    public Timestamp getDiscountTo() {
        return discountTo;
    }

    public void setDiscountTo(Timestamp discountTo) {
        this.discountTo = discountTo;
    }

    public String getDiscountToFormat() {
        return discountToFormat;
    }

    public void setDiscountToFormat(String discountToFormat) {
        this.discountToFormat = discountToFormat;
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
