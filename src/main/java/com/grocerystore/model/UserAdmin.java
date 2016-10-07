package com.grocerystore.model;

import java.sql.Timestamp;

public class UserAdmin {

    private Integer id;
    private String role;
    private String username;
    private String password;
    private String name;
    private String surname;
    private int birthday;
    private int birthmonth;
    private int birthyear;
    private int age;
    private String birthLocation;
    private String birthCountry;
    private String mobilePhone;
    private String phone;
    private String fax;
    private String country;

    private Timestamp signupAt;
    private String    signupAtFormat;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public int getBirthmonth() {
        return birthmonth;
    }

    public void setBirthmonth(int birthmonth) {
        this.birthmonth = birthmonth;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthLocation() {
        return birthLocation;
    }

    public void setBirthLocation(String birthLocation) {
        this.birthLocation = birthLocation;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Timestamp getSignupAt() {
        return signupAt;
    }

    public void setSignupAt(Timestamp signupAt) {
        this.signupAt = signupAt;
    }

    public String getSignupAtFormat() {
        return signupAtFormat;
    }

    public void setSignupAtFormat(String signupAtFormat) {
        this.signupAtFormat = signupAtFormat;
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
        return "UserAdmin [id=" + id + ", role=" + role + ", username="
                + username + ", password=" + password + ", name=" + name
                + ", surname=" + surname + ", birthday=" + birthday
                + ", birthmonth=" + birthmonth + ", birthyear=" + birthyear
                + ", age=" + age + ", birthLocation=" + birthLocation
                + ", birthCountry=" + birthCountry + ", mobilePhone="
                + mobilePhone + ", phone=" + phone + ", fax=" + fax
                + ", country=" + country + ", signupAt=" + signupAt
                + ", signupAtFormat=" + signupAtFormat + ", updatedAt="
                + updatedAt + ", updatedAtFormat=" + updatedAtFormat
                + ", status=" + status + "]";
    }

}
