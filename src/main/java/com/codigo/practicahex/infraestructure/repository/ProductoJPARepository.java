package com.codigo.practicahex.infraestructure.repository;

import com.codigo.practicahex.infraestructure.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductoJPARepository extends JpaRepository<ProductoEntity, Long> {
}
