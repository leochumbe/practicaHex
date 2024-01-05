package com.codigo.practicahex.domain.models;

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
    private float precio_unitario;
    private float subtotal;

}
