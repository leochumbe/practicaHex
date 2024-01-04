package com.codigo.practicahex.infraestructure.repository;

import com.codigo.practicahex.domain.models.Producto;
import com.codigo.practicahex.domain.ports.out.ProductoOut;
import com.codigo.practicahex.infraestructure.entity.ProductoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductoJPARepositoryAdapter implements ProductoOut {
    private final ProductoJPARepository productoJPARepository;

    public ProductoJPARepositoryAdapter(ProductoJPARepository productoJPARepository) {
        this.productoJPARepository = productoJPARepository;
    }

    @Override
    public List<Producto> getTodos() {
        List<Producto> productList = productoJPARepository.findAll().stream().map(ProductoEntity::toDomainModel).collect(Collectors.toList());
        return productList;
    }

    @Override
    public Producto addProducto(Producto producto) {
        ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
        return productoJPARepository.save(productoEntity).toDomainModel();
    }

    @Override
    public Optional<Producto> getProducto(Long id) {
        return productoJPARepository.findById(id).map(ProductoEntity::toDomainModel);
    }

    @Override
    public Optional<Producto> updateProducto(Long id, Producto producto) {
        if(productoJPARepository.existsById(id)){
            ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
            return Optional.of(productoJPARepository.save(productoEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteProducto(Long id) {
        if (productoJPARepository.existsById(id)){
            productoJPARepository.deleteById(id);
            return true;
        }
        return false;
    }
}
