package com.example.crudpet.controller;

import com.example.crudpet.dto.Category;
import com.example.crudpet.dto.Pet;
import com.example.crudpet.dto.Product;
import com.example.crudpet.entity.ProductModel;
import com.example.crudpet.repository.CategoryRepository;
import com.example.crudpet.repository.PetRepository;
import com.example.crudpet.repository.ProductRepository;
import com.example.crudpet.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.ExpressionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    //get all employees
//    @GetMapping("/products/{petid}/{supplierid}/{categoryid}")
//    public Page<Product> getAllProduct(@PathVariable(value = "petid") int petid,@PathVariable(value = "supplierid") int supplierid,
//                                       @PathVariable(value = "categoryid") int categoryid,Pageable pageable){
//        return productRepository.findAllByIdPageable(petid,supplierid,categoryid,pageable);
//    }
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @PostMapping("/createproducts/{petid}/{supplierid}/{categoryid}")
    @Transactional
    public Product createProduct(@PathVariable(value = "petid") int petid,@PathVariable(value = "supplierid") int supplierid,
                                 @PathVariable(value = "categoryid") int categoryid,
                                 @RequestBody Product product) {
        return  petRepository.findById(petid).map(pet->{
            product.setPet(pet);
             supplierRepository.findById(supplierid).map(supplier -> {
                 product.setSupplier(supplier);
                 categoryRepository.findById(categoryid).map(category -> {
                     product.setCategory(category);
                     return productRepository.save(product);
                 }).orElseThrow(() -> new ExpressionException("PostId " + categoryid + " not found"));
                 return productRepository.save(product);
             }).orElseThrow(() -> new ExpressionException("PostId " + supplierid + " not found"));
            return productRepository.save(product);
        }).orElseThrow(() -> new ExpressionException("PostId " + petid + " not found"));
    }

    @PutMapping("/updateproduct/{productid}")
    public Product updateProduct(@PathVariable(value = "productid") int productid,@RequestParam(value = "description") String description) {

//        Product productupdate= productRepository.findById(productid)
//        .orElseThrow(() -> new ExpressionException("CommentId " + productid + "not found"));
//        productupdate.setDescription(productrequest.getDescription());
//        Product afterupdate=productRepository.save(productupdate);
//        productRepository.updateData();
      Product productnew=  productRepository.updateProduct(productid,description);

        return productnew;
    }

    @GetMapping("/getproduct/{productid}")
    public Product getProductById(@PathVariable(value = "productid") int productid){
        return productRepository.findById(productid).orElseThrow(()->new ExpressionException("not found employee"));
    }


//    @GetMapping("/getcategory")
//    @Transactional
//    public List<Category> getAllCategory(){
//        return categoryRepository.findAll();
//    }

    @DeleteMapping("/deleteproduct/{productid}")
    public void deleteProduct(@PathVariable(value = "productid") int productid){
         productRepository.getListAfterDelete(productid);
         List<Product> productsub=productRepository.findAll();
         if(productsub.size()==1){
             productRepository.getListAfterDelete(productid);
             productRepository.updateData();
         }

    }

}
