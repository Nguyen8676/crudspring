package com.example.crudpet.repository;

import com.example.crudpet.dto.Category;
import com.example.crudpet.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
