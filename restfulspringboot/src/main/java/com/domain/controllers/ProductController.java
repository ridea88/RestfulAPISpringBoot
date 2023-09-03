package com.domain.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.models.entities.Product;
import com.domain.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    

    @Autowired
    private ProductService productService;


    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.save(product);
    }


    @GetMapping
    public Iterable<Product>findAll(){
        return productService.findAll();
    }


    @GetMapping("/{id}")
public ResponseEntity<Product> findOne(@PathVariable("id") Long id) {
    try {
        Product product = productService.findOne(id);
        return ResponseEntity.ok(product);
    } catch (NoSuchElementException e) {
        // Tangani pengecualian ketika ID tidak ditemukan
        return ResponseEntity.notFound().build();
    }
}



    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.save(product);
    }


    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long id){
         productService.removeOne(id);
    }
}
