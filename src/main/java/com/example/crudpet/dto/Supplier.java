package com.example.crudpet.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SUPPLIER")
public class Supplier {
    @Id
    @Column(name = "SUPPlIER_ID")
    private int supplierid;

    @Column(name = "NAME")
    private String namesupplier;

    @Column(name = "PHONE")
    private String phonenumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier",cascade = CascadeType.ALL)
    private List<Product> productList;

    public Supplier() {

    }

    public Supplier(int supplierid, String namesupplier, String phonenumber, String email, String address, List<Product> productList) {
        this.supplierid = supplierid;
        this.namesupplier = namesupplier;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
        this.productList = productList;
    }

    public int getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(int supplierid) {
        this.supplierid = supplierid;
    }

    public String getNamesupplier() {
        return namesupplier;
    }

    public void setNamesupplier(String namesupplier) {
        this.namesupplier = namesupplier;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
