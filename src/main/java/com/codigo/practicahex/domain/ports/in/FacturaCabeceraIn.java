package com.codigo.practicahex.domain.ports.in;

import com.codigo.practicahex.domain.models.FacturaCabecera;

import java.util.List;
import java.util.Optional;

public interface FacturaCabeceraIn {
    List<FacturaCabecera> obtenerTodos();
    FacturaCabecera crearFacturaCabecera(FacturaCabecera facturaCabecera);
    Optional<FacturaCabecera> getFacturaCabecera(Long id);
    Optional<FacturaCabecera> actualizarFacturaCabecera(Long id, FacturaCabecera facturaCabecera);
    boolean borrarFacturaCabecera(Long id);
}
