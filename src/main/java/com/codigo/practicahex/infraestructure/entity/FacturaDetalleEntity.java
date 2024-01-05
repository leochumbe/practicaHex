package com.codigo.practicahex.infraestructure.entity;

import com.codigo.practicahex.domain.models.FacturaDetalle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "facturadetalle")
public class FacturaDetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    @JsonIgnore
    private FacturaCabeceraEntity facturaCabecera;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    @JsonIgnore
    private ProductoEntity producto;

    private int cantidad;
    private float precio_unitario;
    private float subtotal;

    public FacturaDetalleEntity() {
    }

    public FacturaDetalleEntity(Long id, FacturaCabeceraEntity facturaCabecera, ProductoEntity producto, int cantidad, float prec_unitario, float subtotal) {
        this.id = id;
        this.facturaCabecera = facturaCabecera;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio_unitario = prec_unitario;
        this.subtotal = subtotal;
    }

    public static FacturaDetalleEntity fromDomainModel(FacturaDetalle facturaDetalle){
        return new FacturaDetalleEntity(
                facturaDetalle.getId(),
                FacturaCabeceraEntity.fromDomainModel(facturaDetalle.getFacturaCabecera()),
                ProductoEntity.fromDomainModel(facturaDetalle.getProducto()),
                facturaDetalle.getCantidad(),
                facturaDetalle.getPrecio_unitario(),
                facturaDetalle.getSubtotal());
    }
    public FacturaDetalle toDomainModel(){
        return new FacturaDetalle(id, facturaCabecera.toDomainModel(), producto.toDomainModel(), cantidad, precio_unitario, subtotal);
    }
}
