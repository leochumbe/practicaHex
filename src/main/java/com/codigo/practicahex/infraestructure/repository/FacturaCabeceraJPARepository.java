package com.codigo.practicahex.infraestructure.repository;

import com.codigo.practicahex.infraestructure.entity.FacturaCabeceraEntity;
import com.codigo.practicahex.infraestructure.entity.FacturaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaCabeceraJPARepository extends JpaRepository<FacturaCabeceraEntity, Long> {
}
