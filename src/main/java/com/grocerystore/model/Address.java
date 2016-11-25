package com.grocerystore.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name="address")
public class Address {

    @Id
    @Column(name="id", unique=true, nullable=false)
    private long id;

    @Column(name = "id_customer", columnDefinition="long default '0'", nullable=false)
    private long idCustomer;

    @Column(name = "address_type", nullable=false, columnDefinition="int default '1'")
    private int addressType;

    @Column(name = "same_address", columnDefinition = "boolean default false", nullable=false)
    private boolean sameAddress;

    @Column(name = "customer_default", columnDefinition = "boolean default false", nullable=false)
    private boolean customerDefault;

    @Size(min=3, max=80)
    @Column(name = "address_1", nullable=false)
    private String address1;

    @Size(max=60)
    @Column(name = "address_2", nullable=false)
    private String address2;

    @Size(min=3, max=80)
    @Column(name = "locality", nullable=false)
    private String locality;

    @Size(min=3, max=50)
    @Column(name = "province", nullable=false)
    private String province;

    @Size(min=3, max=10)
    @Column(name = "postcode", nullable=false)
    private String postcode;

    @Size(min=3, max=50)
    @Column(name = "country", nullable=false)
    private String country;

    @Column(name = "prg", nullable=false, columnDefinition="int default '1'")
    private int prg;

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
    private int status; // default 1

    @ManyToOne
    @JoinColumn(name="id", referencedColumnName="id", insertable=false, updatable=false)
    private Customer customer;

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
    public int getAddressType() {
        return addressType;
    }
    public void setAddressType(int addressType) {
        this.addressType = addressType;
    }
    public boolean isSameAddress() {
        return sameAddress;
    }
    public void setSameAddress(boolean sameAddress) {
        this.sameAddress = sameAddress;
    }
    public boolean isCustomerDefault() {
        return customerDefault;
    }
    public void setCustomerDefault(boolean customerDefault) {
        this.customerDefault = customerDefault;
    }
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getLocality() {
        return locality;
    }
    public void setLocality(String locality) {
        this.locality = locality;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getPrg() {
        return prg;
    }
    public void setPrg(int prg) {
        this.prg = prg;
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
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", idCustomer=" + idCustomer
                + ", addressType=" + addressType + ", sameAddress="
                + sameAddress + ", customerDefault=" + customerDefault
                + ", address1=" + address1 + ", address2=" + address2
                + ", locality=" + locality + ", province=" + province
                + ", postcode=" + postcode + ", country=" + country + ", prg="
                + prg + ", createdAt=" + createdAt + ", createdAtFormat="
                + createdAtFormat + ", updatedAt=" + updatedAt
                + ", updatedAtFormat=" + updatedAtFormat + ", status=" + status + "]";
    }

}
