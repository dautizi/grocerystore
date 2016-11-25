package com.grocerystore.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name="credit_card")
public class CreditCard {

    @Id
    @Column(name="id", unique=true, nullable=false)
    private long id;

    @Column(name="id_customer", columnDefinition="long default '0'")
    private long idCustomer;

    @Size(max=50)
    @Column(name="brand", nullable=false)
    private String brand;
    
    @Size(max=50)
    @Column(name="description", nullable=false)
    private String description;

    @Column(name="prg", nullable=false, columnDefinition="int default '1'")
    private int prg;

    @Size(max=30)
    @Column(name="cc_code", nullable=false)
    private String ccCode;

    @Column(name="security_code", nullable=false, columnDefinition="int default '0'")
    private int securityCode;

    @Size(max=50)
    @Column(name="holder_name", nullable=false)
    private String holderName;

    @Size(max=10)
    @Column(name="expire_date", nullable=false)
    private String expireDate;

    @Column(name="expire_month", nullable=false, columnDefinition="int default '0'")
    private int expireMonth;

    @Column(name="expire_year", nullable=false, columnDefinition="int default '0'")
    private int expireYear;

    @Column(name="expired", columnDefinition = "boolean default false", nullable=false)
    private boolean expired;

    @Column(name="validated", columnDefinition = "boolean default false", nullable=false)
    private boolean validated;

    @Type(type="timestamp")
    @Column(name="created_at", nullable=true)
    private Timestamp createdAt;
    @Transient
    private String    createdAtFormat;

    @Type(type="timestamp")
    @Column(name="updated_at", nullable=true)
    private Timestamp updatedAt;
    @Transient
    private String    updatedAtFormat;

    @Column(name="status", nullable=false, columnDefinition="int default '1'")
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrg() {
        return prg;
    }

    public void setPrg(int prg) {
        this.prg = prg;
    }

    public String getCcCode() {
        return ccCode;
    }

    public void setCcCode(String ccCode) {
        this.ccCode = ccCode;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public int getExpireMonth() {
        return expireMonth;
    }

    public void setExpireMonth(int expireMonth) {
        this.expireMonth = expireMonth;
    }

    public int getExpireYear() {
        return expireYear;
    }

    public void setExpireYear(int expireYear) {
        this.expireYear = expireYear;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
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
        return "CreditCard [id=" + id + ", idCustomer=" + idCustomer
                + ", brand=" + brand + ", description=" + description + ", prg="
                + prg + ", ccCode=" + ccCode + ", securityCode=" + securityCode
                + ", holderName=" + holderName + ", expireDate=" + expireDate
                + ", expireMonth=" + expireMonth + ", expireYear=" + expireYear
                + ", expired=" + expired + ", validated=" + validated
                + ", createdAt=" + createdAt + ", createdAtFormat="
                + createdAtFormat + ", updatedAt=" + updatedAt
                + ", updatedAtFormat=" + updatedAtFormat + ", status=" + status
                + "]";
    }

}
