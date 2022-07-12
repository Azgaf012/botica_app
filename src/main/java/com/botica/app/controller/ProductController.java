package com.botica.app.controller;

import com.botica.app.entity.Product;
import com.botica.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/register")
    private ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("/find/{id}")
    private ResponseEntity<Product> findProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/list")
    private ResponseEntity<List<Product>> findProduct(){
        return ResponseEntity.ok(productService.productsList());
    }

    @PutMapping("/update")
    private ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.update(product));
    }
}
