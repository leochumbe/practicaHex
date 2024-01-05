package com.codigo.practicahex.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaCabecera {
    private Long id;
    private String cliente_nombre;
    private String cliente_num_documento;
    private Date fecha_emision;
    private Float total;
}
