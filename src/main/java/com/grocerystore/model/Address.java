package com.grocerystore.model;

import java.sql.Timestamp;

public class Address {

    private Integer id;
    private Integer idCustomer;
    private String addressType;
    private boolean sameAddress;
    private boolean customerDefault;
    private String address1;
    private String address2;
    private String locality;
    private String province;
    private String postcode;
    private String country;
    private int prg;

    private Timestamp createdAt;
    private String    createdAtFormat;

    private Timestamp updatedAt;
    private String    updatedAtFormat;

    // default '1'
    private int status;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }
    public String getAddressType() {
        return addressType;
    }
    public void setAddressType(String addressType) {
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
                + ", updatedAtFormat=" + updatedAtFormat + ", status=" + status
                + "]";
    }

}
