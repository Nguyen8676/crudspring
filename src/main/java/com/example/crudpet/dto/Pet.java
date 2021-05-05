package com.example.crudpet.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PET")
public class Pet {

    @Id
    @Column(name = "PET_ID")
    private int petid;

    @Column(name = "NAME")
    private String namepet;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pet",cascade = CascadeType.ALL)
//    private List<Product> productList;

    public Pet() {

    }

    public Pet(int petid, String namepet) {
        this.petid = petid;
        this.namepet = namepet;
    }

    public int getPetid() {
        return petid;
    }

    public void setPetid(int petid) {
        this.petid = petid;
    }

    public String getNamepet() {
        return namepet;
    }

    public void setNamepet(String namepet) {
        this.namepet = namepet;
    }
}
