package com.grocerystore.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private long id;

    @Size(max=80)
    @Column(name = "email", nullable=false)
    private String email;

    @Column(name = "email_verification", columnDefinition = "boolean default false", nullable = false)
    private boolean emailVerification;

    @Size(max=40)
    @Column(name = "username", nullable=true)
    private String username;

    @Size(max=255)
    @Column(name = "password", nullable=true)
    private String password;

    @Size(max=40)
    @Column(name = "name", nullable=true)
    private String name;

    @Size(max=50)
    @Column(name = "surname", nullable=true)
    private String surname;

    @Column(name = "birthday", nullable=false, columnDefinition="int default '0'")
    private int birthday;

    @Column(name = "birthmonth", nullable=false, columnDefinition="int default '0'")
    private int birthmonth;

    @Column(name = "birthyear", nullable=false, columnDefinition="int default '0'")
    private int birthyear;

    @Column(name = "age", nullable=false, columnDefinition="int default '0'")
    private int age;

    @Size(max=50)
    @Column(name = "birth_location", nullable=true)
    private String birthLocation;

    @Size(max=50)
    @Column(name = "birth_country", nullable=true)
    private String birthCountry;

    @Size(max=20)
    @Column(name = "mobile_phone", nullable=true)
    private String mobilePhone;

    @Size(max=20)
    @Column(name = "phone", nullable=true)
    private String phone;

    @Size(max=20)
    @Column(name = "fax", nullable=true)
    private String fax;

    @Size(max=50)
    @Column(name = "country", nullable=true)
    private String country;

    @Column(name = "visits", nullable=false, columnDefinition="int default '0'")
    private int visits;

    @Column(name = "transactions", nullable=false, columnDefinition="int default '0'")
    private int transactions;

    @Type(type="timestamp")
    @Column(name = "signup_at", nullable=true)
    private Timestamp signupAt;
    @Transient
    private String    signupAtFormat;

    @Type(type="timestamp")
    @Column(name = "updated_at", nullable=true)
    private Timestamp updatedAt;
    @Transient
    private String    updatedAtFormat;

    @Column(name = "status", nullable=false, columnDefinition="int default '1'")
    private int status;

    // One to Many
    @OneToMany(mappedBy="customer", targetEntity=Address.class, fetch=FetchType.EAGER)
    Set<Address> addresses;

    // One to Many
    @OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
    Set<CustomerOrder> orders;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="customer_discount", 
        joinColumns = { @JoinColumn(name = "id_customer") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_discount") })
    private Set<Discount> discounts;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean getEmailVerification() {
        return emailVerification;
    }
    public void setEmailVerification(boolean emailVerification) {
        this.emailVerification = emailVerification;
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
    public int getVisits() {
        return visits;
    }
    public void setVisits(int visits) {
        this.visits = visits;
    }
    public int getTransactions() {
        return transactions;
    }
    public void setTransactions(int transactions) {
        this.transactions = transactions;
    }
    public Timestamp getSignupAt() {
        return signupAt;
    }
    public void setSignupAt(Timestamp signupAt) {
        this.signupAt = signupAt;
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
    public String getSignupAtFormat() {
        return signupAtFormat;
    }
    public void setSignupAtFormat(String signupAtFormat) {
        this.signupAtFormat = signupAtFormat;
    }
    public String getUpdatedAtFormat() {
        return updatedAtFormat;
    }
    public void setUpdatedAtFormat(String updatedAtFormat) {
        this.updatedAtFormat = updatedAtFormat;
    }
    public Set<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
    public Set<CustomerOrder> getOrders() {
        return orders;
    }
    public void setOrders(Set<CustomerOrder> orders) {
        this.orders = orders;
    }
    public Set<Discount> getDiscounts() {
        return discounts;
    }
    public void setDiscounts(Set<Discount> discounts) {
        this.discounts = discounts;
    }

}
