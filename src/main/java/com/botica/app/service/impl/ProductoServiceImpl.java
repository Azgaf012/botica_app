package com.botica.app.service.impl;

import com.botica.app.entity.Producto;
import com.botica.app.presenter.ProductoPresenter;
import com.botica.app.repository.ProductoRepository;
import com.botica.app.service.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Producto buscaxId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto buscarxNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findByEstadoTrue();
    }

    @Override
    public void delete(long id) {
        Producto producto = this.buscaxId(id);
        producto.setEstado(false);
        productoRepository.save(producto);
    }

    @Override
    public Producto actualizar(Producto producto) {
        Producto productoDB= this.buscaxId(producto.getId());
        productoDB.setNombre(producto.getNombre());
        productoDB.setCantidad(producto.getCantidad());
        productoDB.setUnidadMedida(producto.getUnidadMedida());
        productoDB.setPrecio(producto.getPrecio());
        productoDB.setStock(producto.getStock());
        productoDB.setLaboratorio(producto.getLaboratorio());
        productoDB.setEstado(producto.isEstado());
        return productoRepository.save(productoDB);
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    private ProductoPresenter toPresenter(Producto producto){
        return modelMapper.map(producto,ProductoPresenter.class);
    }
}
