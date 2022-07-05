package com.botica.app.service.impl;

import com.botica.app.entity.Product;
import com.botica.app.presenter.ProductPresenter;
import com.botica.app.repository.ProductRepository;
import com.botica.app.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product findByName(String nombre) {
        return productRepository.findByNombre(nombre);
    }

    @Override
    public List<Product> productsList() {
        return productRepository.findByEstadoTrue();
    }

    @Override
    public void delete(long id) {
        Product product = this.findById(id);
        product.setEstado(false);
        productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        Product productDB = this.findById(product.getId());
        productDB.setName(product.getName());
        productDB.setCant(product.getCant());
        productDB.setUnitMeasurement(product.getUnitMeasurement());
        productDB.setPrice(product.getPrice());
        productDB.setStock(product.getStock());
        productDB.setLaboratory(product.getLaboratory());
        productDB.setEstado(product.isEstado());
        return productRepository.save(productDB);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    private ProductPresenter toPresenter(Product product){
        return modelMapper.map(product, ProductPresenter.class);
    }
}
