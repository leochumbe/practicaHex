package com.codigo.practicahex.application.service;

import com.codigo.practicahex.domain.models.FacturaCabecera;
import com.codigo.practicahex.domain.ports.in.FacturaCabeceraIn;

import java.util.List;
import java.util.Optional;

public class FacturaCabeceraService implements FacturaCabeceraIn {

    private final FacturaCabeceraIn facturaCabeceraIn;

    public FacturaCabeceraService(FacturaCabeceraIn facturaCabeceraIn) {

        this.facturaCabeceraIn = facturaCabeceraIn;
    }

    @Override
    public List<FacturaCabecera> obtenerTodos() {
        return facturaCabeceraIn.obtenerTodos();
    }

    @Override
    public FacturaCabecera crearFacturaCabecera(FacturaCabecera facturaCabecera) {
        return facturaCabeceraIn.crearFacturaCabecera(facturaCabecera);
    }

    @Override
    public Optional<FacturaCabecera> getFacturaCabecera(Long id) {

        return facturaCabeceraIn.getFacturaCabecera(id);
    }

    @Override
    public Optional<FacturaCabecera> actualizarFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        return facturaCabeceraIn.actualizarFacturaCabecera(id, facturaCabecera);
    }

    @Override
    public boolean borrarFacturaCabecera(Long id) {

        return facturaCabeceraIn.borrarFacturaCabecera(id);
    }
}