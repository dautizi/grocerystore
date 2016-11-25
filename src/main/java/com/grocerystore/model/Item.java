package com.grocerystore.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name="item")
public class Item {

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

    @Column(name = "availability", nullable = false, columnDefinition="int default '1'")
    private int availability;

    @Type(type="timestamp")
    @Column(name = "next_availability", nullable = true)
    private Timestamp nextAvailability;
    @Transient
    private String nextAvailabilityFormat;

    @Digits(integer=10, fraction=2)
    @Column(name = "full_price", nullable = false)
    private BigDecimal fullPrice;

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

    @Column(name = "status", nullable = false, columnDefinition="int default '1'")
    private int status;

    @Size(max=200)
    @Column(name = "tag", nullable = true)
    private String tag;

    // One to Many
    @OneToMany(mappedBy="item", targetEntity=ItemImage.class)
    private Set<ItemImage> images;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="item_discount", 
        joinColumns = { @JoinColumn(name = "id_item") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_discount") })
    private Set<Discount> discounts;

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

    public Set<ItemImage> getImages() {
        return images;
    }

    public void setImages(Set<ItemImage> images) {
        this.images = images;
    }

    public Set<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Set<Discount> discounts) {
        this.discounts = discounts;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", title=" + title
                + ", cover=" + cover + ", nutritionalImage=" + nutritionalImage
                + ", availability=" + availability + ", nextAvailability="
                + nextAvailability + ", nextAvailabilityFormat="
                + nextAvailabilityFormat + ", fullPrice=" + fullPrice
                + ", createdAt=" + createdAt + ", createdAtFormat="
                + createdAtFormat + ", updatedAt=" + updatedAt
                + ", updatedAtFormat=" + updatedAtFormat + ", status=" + status
                + ", tag=" + tag + ", images=" + images + ", discounts="
                + discounts + "]";
    }

}
