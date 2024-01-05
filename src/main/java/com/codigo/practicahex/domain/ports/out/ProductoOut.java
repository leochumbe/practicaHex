package com.codigo.practicahex.domain.ports.out;

import com.codigo.practicahex.domain.models.Producto;
//import com.codigo.practicahex.infraestructure.entity.ProductoEntity;

import java.util.List;
import java.util.Optional;

public interface ProductoOut {
    List<Producto> getTodos();
    Producto addProducto(Producto producto);
    Optional<Producto> getProducto(Long id);
    Optional<Producto> updateProducto(Long id, Producto producto);
    boolean deleteProducto(Long id);
}
