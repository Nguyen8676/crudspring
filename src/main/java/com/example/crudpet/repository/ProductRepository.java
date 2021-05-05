package com.example.crudpet.repository;

import com.example.crudpet.dto.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
//    @Modifying
//    @Query(value = "insert into PRODUCT (PRODUCT_ID,NAME,PRICE,DESCRIPTION,CREATEDDATE,QUANTITY,STATUS,PROMOTIONPRICE,DISCOUNT,PET_ID,SUPPLIER_ID,CATEGORY_ID) " +
//            "VALUES (null,?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11) ",nativeQuery = true)
//    @Transactional
//    Product createProduct(String productname,int price,String description,String createdate,int quantity,String status,
//                          int promotion ,int discount,int petid,int supplierid,int cateid) ;
//    @Transactional
//    Page<Product> findAllByIdPageable(int petid,int supplierid,int categoryid, Pageable pageable);
    @Modifying
    @Transactional
    @Query(value = " delete From PRODUCT where PRODUCT_ID=:productid",nativeQuery = true)
    void getListAfterDelete(@Param("productid")int productid);


    @Transactional
    @Query(value = "UPDATE PRODUCT SET DESCRIPTION = :desciption WHERE PRODUCT_ID= :productid",nativeQuery = true)
    Product updateProduct(@Param("productid")int productid,@Param("desciption")String desciption);

    @Transactional
    @Query(value = "select * from product where product_id=?1 and pet_id=?2 and supplier_id=?3 and category_id=?4",nativeQuery = true)
    Optional<Product> findByIdAndDelete(int productid, int petid, int supplierid,int categoryid);
    @Transactional
    @Query(value = " COMMIT WORK" ,nativeQuery = true)
    void updateData();
}
