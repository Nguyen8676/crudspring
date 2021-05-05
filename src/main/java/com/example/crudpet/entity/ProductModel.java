package com.example.crudpet.entity;

import com.example.crudpet.dto.Pet;

import javax.persistence.Entity;
import javax.persistence.Id;


public class ProductModel {


    private String productname;
    private int price;
    private String description;
    private String createdate;
    private int quantity;
    private String status;
    private int promotion;
    private int discount;
    private int petid;
    private int supplierid;
    private int cateid;

    public ProductModel() {

    }

    public ProductModel(String productname, int price, String description, String createdate, int quantity, String status, int promotion, int discount, int petid, int supplierid, int cateid) {
        this.productname = productname;
        this.price = price;
        this.description = description;
        this.createdate = createdate;
        this.quantity = quantity;
        this.status = status;
        this.promotion = promotion;
        this.discount = discount;
        this.petid = petid;
        this.supplierid = supplierid;
        this.cateid = cateid;
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

    public int getPetid() {
        return petid;
    }

    public void setPetid(int petid) {
        this.petid = petid;
    }

    public int getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(int supplierid) {
        this.supplierid = supplierid;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }
}
