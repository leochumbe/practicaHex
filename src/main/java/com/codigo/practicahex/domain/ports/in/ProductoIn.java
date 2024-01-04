package com.codigo.practicahex.domain.ports.in;

import com.codigo.practicahex.domain.models.Producto;
import com.codigo.practicahex.infraestructure.entity.ProductoEntity;

import java.util.List;
import java.util.Optional;

public interface ProductoIn {
    List<Producto> obtenerTodos();
    Producto crearProducto(Producto producto);
    Optional<Producto> getProducto(Long id);
    Optional<Producto> actualizarProducto(Long id, Producto producto);
    boolean borrarProducto(Long id);
}
