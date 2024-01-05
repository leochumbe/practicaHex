package com.codigo.practicahex.infraestructure.entity;

import com.codigo.practicahex.domain.models.FacturaCabecera;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "facturacabecera")
public class FacturaCabeceraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factura_id")
    private Long id;
    private String cliente_nombre;
    private String cliente_num_documento;
    private Date fecha_emision;
    private Float total;

    // relation with FacturaDetalleEntity
    @OneToMany(mappedBy = "facturaCabecera")
    private List<FacturaDetalleEntity> facturaDetalleEntityList;
    public FacturaCabeceraEntity() {
    }

    public FacturaCabeceraEntity(Long id, String cliente_nombre, String cliente_num_documento, Date fecha_emision, Float total) {
        this.id = id;
        this.cliente_nombre = cliente_nombre;
        this.cliente_num_documento = cliente_num_documento;
        this.fecha_emision = fecha_emision;
        this.total = total;
    }

    public static FacturaCabeceraEntity fromDomainModel(FacturaCabecera facturaCabecera){
        return new FacturaCabeceraEntity(facturaCabecera.getId(),
                                         facturaCabecera.getCliente_nombre(),
                                         facturaCabecera.getCliente_num_documento(),
                                         facturaCabecera.getFecha_emision(),
                                         facturaCabecera.getTotal());
    }

    public FacturaCabecera toDomainModel(){
        return new FacturaCabecera(id, cliente_nombre, cliente_num_documento, fecha_emision, total);
    }
}
