package com.codigo.practicahex.application.service;

import com.codigo.practicahex.domain.models.FacturaDetalle;
import com.codigo.practicahex.domain.ports.in.FacturaDetalleIn;

import java.util.List;
import java.util.Optional;

public class FacturaDetalleService implements FacturaDetalleIn {

    private final FacturaDetalleIn facturaDetalleIn;

    public FacturaDetalleService(FacturaDetalleIn facturaDetalleIn) {
        this.facturaDetalleIn = facturaDetalleIn;
    }

    @Override
    public List<FacturaDetalle> obtenerTodos() {
        return facturaDetalleIn.obtenerTodos();
    }

    @Override
    public FacturaDetalle crearFacturaDetalle(FacturaDetalle facturaDetalle) {
        return facturaDetalleIn.crearFacturaDetalle(facturaDetalle);
    }

    @Override
    public Optional<FacturaDetalle> getFacturaDetalle(Long id) {
        return facturaDetalleIn.getFacturaDetalle(id);
    }

    @Override
    public Optional<FacturaDetalle> actualizarFacturaDetalle(Long id, FacturaDetalle facturaDetalle) {
        return facturaDetalleIn.actualizarFacturaDetalle(id,facturaDetalle);
    }

    @Override
    public boolean borrarFacturaDetalle(Long id) {
        return facturaDetalleIn.borrarFacturaDetalle(id);
    }
}
