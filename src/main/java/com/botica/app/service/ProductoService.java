package com.botica.app.service;

import com.botica.app.entity.Producto;

import java.util.List;

public interface ProductoService {
    Producto buscaxId(Long id);
    Producto buscarxNombre(String nombre);
    List<Producto> listarProductos();
    void delete(long id);
    Producto actualizar(Producto producto);
    Producto guardar(Producto producto);
}
