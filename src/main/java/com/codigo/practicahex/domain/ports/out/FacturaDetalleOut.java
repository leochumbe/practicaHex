package com.codigo.practicahex.domain.ports.out;

import com.codigo.practicahex.domain.models.FacturaDetalle;

import java.util.List;
import java.util.Optional;

public interface FacturaDetalleOut {
    List<FacturaDetalle> getTodos();
    FacturaDetalle addFacturaDetalle(FacturaDetalle facturaDetalle);
    Optional<FacturaDetalle> getFacturaDetalle(Long id);
    Optional<FacturaDetalle> updateFacturaDetalle(Long id, FacturaDetalle facturaDetalle);
    boolean deleteFacturaDetalle(Long id);
}
