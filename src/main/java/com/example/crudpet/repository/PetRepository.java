package com.example.crudpet.repository;

import com.example.crudpet.dto.Pet;
import com.example.crudpet.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {

}
