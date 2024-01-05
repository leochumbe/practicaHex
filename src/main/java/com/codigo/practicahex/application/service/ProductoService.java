package com.codigo.practicahex.application.service;

import com.codigo.practicahex.domain.models.Producto;
import com.codigo.practicahex.domain.ports.in.ProductoIn;
//import com.codigo.practicahex.infraestructure.entity.ProductoEntity;

import java.util.List;
import java.util.Optional;

public class ProductoService implements ProductoIn {

    private final ProductoIn productoIn;

    public ProductoService(ProductoIn productoIn) {
        this.productoIn = productoIn;
    }


    @Override
    public List<Producto> obtenerTodos() {
        return productoIn.obtenerTodos();
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoIn.crearProducto(producto);
    }

    @Override
    public Optional<Producto> getProducto(Long id) {
        return productoIn.getProducto(id);
    }

    @Override
    public Optional<Producto> actualizarProducto(Long id, Producto producto) {
        return productoIn.actualizarProducto(id, producto);
    }

    @Override
    public boolean borrarProducto(Long id) {
        return productoIn.borrarProducto(id);
    }
}