package com.codigo.practicahex.domain.ports.out;

import com.codigo.practicahex.domain.models.FacturaCabecera;

import java.util.List;
import java.util.Optional;

public interface FacturaCabeceraOut {
    List<FacturaCabecera> getTodos();
    FacturaCabecera addFacturaCabecera(FacturaCabecera facturaCabecera);
    Optional<FacturaCabecera> getFacturaCabecera(Long id);
    Optional<FacturaCabecera> updateFacturaCabecera(Long id, FacturaCabecera facturaCabecera);
    boolean deleteFacturaCabecera(Long id);
}
