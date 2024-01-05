package com.codigo.practicahex.application.useCase;

import com.codigo.practicahex.domain.models.FacturaCabecera;
import com.codigo.practicahex.domain.ports.in.FacturaCabeceraIn;
import com.codigo.practicahex.domain.ports.out.FacturaCabeceraOut;

import java.util.List;
import java.util.Optional;

public class FacturaCabeceraServiceImpl implements FacturaCabeceraIn {

    private final FacturaCabeceraOut facturaCabeceraOut;

    public FacturaCabeceraServiceImpl(FacturaCabeceraOut facturaCabeceraOut) {
        this.facturaCabeceraOut = facturaCabeceraOut;
    }

    @Override
    public List<FacturaCabecera> obtenerTodos() {
        return facturaCabeceraOut.getTodos();
    }

    @Override
    public FacturaCabecera crearFacturaCabecera(FacturaCabecera facturaCabecera) {
        return facturaCabeceraOut.addFacturaCabecera(facturaCabecera);
    }

    @Override
    public Optional<FacturaCabecera> getFacturaCabecera(Long id) {
        return facturaCabeceraOut.getFacturaCabecera(id);
    }

    @Override
    public Optional<FacturaCabecera> actualizarFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        return facturaCabeceraOut.updateFacturaCabecera(id, facturaCabecera);
    }

    @Override
    public boolean borrarFacturaCabecera(Long id) {
        return facturaCabeceraOut.deleteFacturaCabecera(id);
    }
}