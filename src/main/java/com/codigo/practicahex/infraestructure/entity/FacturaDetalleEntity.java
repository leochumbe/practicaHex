package com.codigo.practicahex.infraestructure.entity;

import com.codigo.practicahex.domain.models.FacturaCabecera;
import com.codigo.practicahex.domain.models.FacturaDetalle;
import com.codigo.practicahex.domain.models.Producto;
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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private FacturaCabeceraEntity facturaCabecera;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoEntity producto;

    private int cantidad;
    private float prec_unit;
    private float sub_total;

    public FacturaDetalleEntity() {
    }

    public FacturaDetalleEntity(Long id, FacturaCabeceraEntity facturaCabecera, ProductoEntity producto, int cantidad, float prec_unit, float sub_total) {
        this.id = id;
        this.facturaCabecera = facturaCabecera;
        this.producto = producto;
        this.cantidad = cantidad;
        this.prec_unit = prec_unit;
        this.sub_total = sub_total;
    }

    public static FacturaDetalleEntity fromDomainModel(FacturaDetalle facturaDetalle){
        return new FacturaDetalleEntity(
                facturaDetalle.getId(),
                FacturaCabeceraEntity.fromDomainModel(facturaDetalle.getFacturaCabecera()),
                ProductoEntity.fromDomainModel(facturaDetalle.getProducto()),
                facturaDetalle.getCantidad(),
                facturaDetalle.getPrec_unit(),
                facturaDetalle.getSub_total());
    }
    public FacturaDetalle toDomainModel(){
        return new FacturaDetalle(id, facturaCabecera.toDomainModel(), producto.toDomainModel(), cantidad, prec_unit, sub_total);
    }
}
