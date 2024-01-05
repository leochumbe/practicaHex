package com.codigo.practicahex.infraestructure.repository;

import com.codigo.practicahex.domain.models.FacturaDetalle;
import com.codigo.practicahex.domain.ports.out.FacturaDetalleOut;
import com.codigo.practicahex.infraestructure.entity.FacturaDetalleEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FacturaDetalleJPARepositoryAdapter implements FacturaDetalleOut {
    private final FacturaDetalleJPARepository facturaDetalleJPARepository;

    public FacturaDetalleJPARepositoryAdapter(FacturaDetalleJPARepository facturaDetalleJPARepository) {
        this.facturaDetalleJPARepository = facturaDetalleJPARepository;
    }


    @Override
    public List<FacturaDetalle> getTodos() {
        List<FacturaDetalle> facturadetalleList = facturaDetalleJPARepository.findAll().stream().map(FacturaDetalleEntity::toDomainModel).collect(Collectors.toList());
        return facturadetalleList;
    }
    @Override
    public FacturaDetalle addFacturaDetalle(FacturaDetalle facturaDetalle) {
        FacturaDetalleEntity facturaDetalleEntity = FacturaDetalleEntity.fromDomainModel(facturaDetalle);
        try {
            FacturaDetalleEntity facturaDetalleEntitySave = facturaDetalleJPARepository.save(facturaDetalleEntity);
            return facturaDetalleEntitySave.toDomainModel();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Optional<FacturaDetalle> getFacturaDetalle(Long id) {
        return facturaDetalleJPARepository.findById(id).map(FacturaDetalleEntity::toDomainModel);
    }

    @Override
    public Optional<FacturaDetalle> updateFacturaDetalle(Long id, FacturaDetalle facturaDetalle) {
        if(facturaDetalleJPARepository.existsById(id)){
            FacturaDetalleEntity facturaDetalleEntity = FacturaDetalleEntity.fromDomainModel(facturaDetalle);
            return Optional.of(facturaDetalleJPARepository.save(facturaDetalleEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteFacturaDetalle(Long id) {
        if(facturaDetalleJPARepository.existsById(id)){
            facturaDetalleJPARepository.deleteById(id);
            return true;
        }
        return false;
    }
}
