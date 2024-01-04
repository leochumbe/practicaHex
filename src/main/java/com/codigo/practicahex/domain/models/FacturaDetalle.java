package com.codigo.practicahex.domain.models;

import com.codigo.practicahex.infraestructure.entity.FacturaCabeceraEntity;
import com.codigo.practicahex.infraestructure.entity.ProductoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDetalle {
    private Long id;
    private FacturaCabecera facturaCabecera;
    private Producto producto;
    private int cantidad;
    private float prec_unit;
    private float sub_total;

}
