package com.example.crudpet.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PARENTCATEGORY")
public class ParentCategory {
    @Id
    @Column(name = "PARENT_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentCategory")
    private List<Category> categoryList;

    public ParentCategory() {

    }

    public ParentCategory(int id, String name, List<Category> categoryList) {
        this.id = id;
        this.name = name;
        this.categoryList = categoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
