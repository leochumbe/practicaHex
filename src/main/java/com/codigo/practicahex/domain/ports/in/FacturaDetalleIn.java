package com.codigo.practicahex.domain.ports.in;

import com.codigo.practicahex.domain.models.FacturaCabecera;
import com.codigo.practicahex.domain.models.FacturaDetalle;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface FacturaDetalleIn {
    List<FacturaDetalle> obtenerTodos();
    FacturaDetalle crearFacturaDetalle(FacturaDetalle facturaDetalle);
    Optional<FacturaDetalle> getFacturaDetalle(Long id);
    Optional<FacturaDetalle> actualizarFacturaDetalle(Long id, FacturaDetalle facturaDetalle);
    boolean borrarFacturaDetalle(Long id);
}
