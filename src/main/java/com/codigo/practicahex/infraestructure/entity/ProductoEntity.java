package com.codigo.practicahex.infraestructure.entity;

import com.codigo.practicahex.domain.models.Producto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Float precio;
    private Integer stock;

    public ProductoEntity() {
    }

    public ProductoEntity(Long id, String nombre, String descripcion, Float precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public static ProductoEntity fromDomainModel(Producto producto){
        return new ProductoEntity(producto.getId(),
                                  producto.getNombre(),
                                  producto.getDescripcion(),
                                  producto.getPrecio(),
                                  producto.getStock());
    }

    public Producto toDomainModel(){
        return new Producto(id, nombre, descripcion, precio, stock);
    }
}