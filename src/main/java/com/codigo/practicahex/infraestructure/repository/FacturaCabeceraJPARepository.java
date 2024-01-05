package com.codigo.practicahex.infraestructure.repository;

import com.codigo.practicahex.infraestructure.entity.FacturaCabeceraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FacturaCabeceraJPARepository extends JpaRepository<FacturaCabeceraEntity, Long> {
}
