package com.codigo.practicahex.application.useCase;

import com.codigo.practicahex.domain.models.Producto;
import com.codigo.practicahex.domain.ports.in.ProductoIn;
import com.codigo.practicahex.domain.ports.out.ProductoOut;
import com.codigo.practicahex.infraestructure.entity.ProductoEntity;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoIn {

    private final ProductoOut productoOut;

    public ProductoServiceImpl(ProductoOut productoOut) {
        this.productoOut = productoOut;
    }

    @Override
    public List<Producto> obtenerTodos() {
        return productoOut.getTodos();
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoOut.addProducto(producto);
    }

    @Override
    public Optional<Producto> getProducto(Long id) {
        return productoOut.getProducto(id);
    }

    @Override
    public Optional<Producto> actualizarProducto(Long id, Producto producto) {
        return productoOut.updateProducto(id, producto);
    }

    @Override
    public boolean borrarProducto(Long id) {
        return productoOut.deleteProducto(id);
    }
}