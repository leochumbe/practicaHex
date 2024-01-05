package com.codigo.practicahex.infraestructure.entity;

import com.codigo.practicahex.domain.models.FacturaDetalle;
import com.codigo.practicahex.domain.models.Producto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@Table(name = "productos")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Long id;
    private String nombre;
    private String descripcion;
    private Float precio;
    private Integer stock;
    // relation with FacturaDetalleEntity
    @OneToMany(mappedBy = "producto")
    private List<FacturaDetalleEntity> facturaDetalleEntityList;
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