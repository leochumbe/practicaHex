package com.codigo.practicahex.infraestructure.repository;

import com.codigo.practicahex.infraestructure.entity.FacturaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FacturaDetalleJPARepository extends JpaRepository<FacturaDetalleEntity, Long> {
}
