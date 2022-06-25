package com.botica.app.controller;

import com.botica.app.entity.Producto;
import com.botica.app.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/registrar")
    private ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    @GetMapping("/buscar/{id}")
    private ResponseEntity<Producto> consultarProducto(@PathVariable("id") Long id){
        return ResponseEntity.ok(productoService.buscaxId(id));
    }

    @GetMapping("/listar")
    private ResponseEntity<List<Producto>> consultarProducto(){
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @PutMapping("/actualizar")
    private ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.actualizar(producto));
    }
}
