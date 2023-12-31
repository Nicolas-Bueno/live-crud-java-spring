package com.example.crud.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.domain.Product.Product;
import com.example.crud.domain.Product.ProductRepository;
import com.example.crud.domain.Product.RequestProduct;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        var allProduct = repository.findAll();
        return ResponseEntity.ok(allProduct);
    }

    @PostMapping
    public ResponseEntity<RequestBody> registerProduct(@RequestBody @Valid RequestProduct data){
        Product newProduct = new Product(data);
        System.out.println(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();
    }
}
