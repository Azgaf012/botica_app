package com.botica.app.repository;

import com.botica.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByNombre(String nombre);
    List<Product> findByEstadoTrue();
}
