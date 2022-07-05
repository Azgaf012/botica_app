package com.botica.app.service;

import com.botica.app.entity.Product;

import java.util.List;

public interface ProductService {
    Product findById(Long id);
    Product findByName(String nombre);
    List<Product> productsList();
    void delete(long id);
    Product update(Product product);
    Product save(Product product);
}
