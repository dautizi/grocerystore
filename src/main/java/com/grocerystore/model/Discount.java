package com.grocerystore.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name="discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min=3, max=50)
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min=3, max=20)
    @Column(name = "description", nullable = false)
    private String description;

    @Size(max=200)
    @Column(name = "cover", nullable = true)
    private String cover;

    @Column(name = "discount_perc", nullable=false, columnDefinition="int default '0'")
    private int percentage;

    @Digits(integer=10, fraction=2)
    @Column(name = "min_money", nullable=true)
    private BigDecimal minMoney;

    @Digits(integer=10, fraction=2)
    @Column(name = "max_saved_money", nullable=true)
    private BigDecimal maxSavedMoney;

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

    @Column(name = "status", nullable = false, columnDefinition="int default '1'")
    private int status;

    @ManyToOne
    @JoinColumn(name="id", referencedColumnName="id", insertable=false, updatable=false)
    private Customer customer;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(BigDecimal minMoney) {
        this.minMoney = minMoney;
    }

    public BigDecimal getMaxSavedMoney() {
        return maxSavedMoney;
    }

    public void setMaxSavedMoney(BigDecimal maxSavedMoney) {
        this.maxSavedMoney = maxSavedMoney;
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

    @Override
    public String toString() {
        return "Discount [id=" + id + ", name=" + name + ", description="
                + description + ", cover=" + cover + ", percentage="
                + percentage + ", minMoney=" + minMoney + ", maxSavedMoney="
                + maxSavedMoney + ", discountFrom=" + discountFrom
                + ", discountFromFormat=" + discountFromFormat + ", discountTo="
                + discountTo + ", discountToFormat=" + discountToFormat
                + ", createdAt=" + createdAt + ", createdAtFormat="
                + createdAtFormat + ", updatedAt=" + updatedAt
                + ", updatedAtFormat=" + updatedAtFormat + ", status=" + status
                + "]";
    }

}
