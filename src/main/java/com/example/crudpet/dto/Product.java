package com.example.crudpet.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private int productid;

    @Column(name = "NAME")
    private String productname;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATEDDATE")
    private String createdate;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PROMOTIONPRICE")
    private int promotion;

    @Column(name = "DISCOUNT")
    private int discount;

//    @Column(name = "PET_ID")
//    private Integer petid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PET_ID")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pet pet;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUPPlIER_ID")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CATEGORY_ID")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;


    public Product() {

    }


    public Product(int productid, String productname, int price, String description, String createdate, int quantity, String status, int promotion, int discount, Pet pet, Supplier supplier, Category category) {
        this.productid = productid;
        this.productname = productname;
        this.price = price;
        this.description = description;
        this.createdate = createdate;
        this.quantity = quantity;
        this.status = status;
        this.promotion = promotion;
        this.discount = discount;
        this.pet = pet;
        this.supplier = supplier;
        this.category = category;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
