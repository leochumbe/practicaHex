package com.codigo.practicahex.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Float precio;
    private Integer stock;
}
