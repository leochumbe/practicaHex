package com.codigo.practicahex.application.useCase;

import com.codigo.practicahex.domain.models.FacturaDetalle;
import com.codigo.practicahex.domain.ports.in.FacturaDetalleIn;
import com.codigo.practicahex.domain.ports.out.FacturaDetalleOut;

import java.util.List;
import java.util.Optional;

public class FacturaDetalleServiceImpl implements FacturaDetalleIn {

    private final FacturaDetalleOut facturaDetalleOut;

    public FacturaDetalleServiceImpl(FacturaDetalleOut facturaDetalleOut) {
        this.facturaDetalleOut = facturaDetalleOut;
    }

    @Override
    public List<FacturaDetalle> obtenerTodos() {
        return facturaDetalleOut.getTodos();
    }

    @Override
    public FacturaDetalle crearFacturaDetalle(FacturaDetalle facturaDetalle) {
        return facturaDetalleOut.addFacturaDetalle(facturaDetalle);
    }

    @Override
    public Optional<FacturaDetalle> getFacturaDetalle(Long id) {
        return facturaDetalleOut.getFacturaDetalle(id);
    }

    @Override
    public Optional<FacturaDetalle> actualizarFacturaDetalle(Long id, FacturaDetalle facturaDetalle) {
        return facturaDetalleOut.updateFacturaDetalle(id, facturaDetalle);
    }

    @Override
    public boolean borrarFacturaDetalle(Long id) {
        return facturaDetalleOut.deleteFacturaDetalle(id);
    }
}
