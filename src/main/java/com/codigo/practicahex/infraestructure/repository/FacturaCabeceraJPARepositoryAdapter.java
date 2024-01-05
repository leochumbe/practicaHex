package com.codigo.practicahex.infraestructure.repository;

import com.codigo.practicahex.domain.models.FacturaCabecera;
import com.codigo.practicahex.domain.ports.out.FacturaCabeceraOut;
import com.codigo.practicahex.infraestructure.entity.FacturaCabeceraEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FacturaCabeceraJPARepositoryAdapter implements FacturaCabeceraOut {
    private final FacturaCabeceraJPARepository facturaCabeceraJPARepository;

    public FacturaCabeceraJPARepositoryAdapter(FacturaCabeceraJPARepository facturaCabeceraJPARepository) {
        this.facturaCabeceraJPARepository = facturaCabeceraJPARepository;
    }

    @Override
    public List<FacturaCabecera> getTodos() {
            List<FacturaCabecera> facturaList = facturaCabeceraJPARepository.findAll().stream().map(FacturaCabeceraEntity::toDomainModel).collect(Collectors.toList());
            return facturaList;
    }
    @Override
    public FacturaCabecera addFacturaCabecera(FacturaCabecera facturaCabecera) {
        FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromDomainModel(facturaCabecera);
        return facturaCabeceraJPARepository.save(facturaCabeceraEntity).toDomainModel();
    }
    @Override
    public Optional<FacturaCabecera> getFacturaCabecera(Long id) {
        return facturaCabeceraJPARepository.findById(id).map(FacturaCabeceraEntity::toDomainModel);
    }
    @Override
    public Optional<FacturaCabecera> updateFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        if(facturaCabeceraJPARepository.existsById(id)){
            FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromDomainModel(facturaCabecera);
            return Optional.of(facturaCabeceraJPARepository.save(facturaCabeceraEntity).toDomainModel());
        }
        return Optional.empty();
    }
    @Override
    public boolean deleteFacturaCabecera(Long id) {
        if(facturaCabeceraJPARepository.existsById(id)){
            facturaCabeceraJPARepository.deleteById(id);
            return true;
        }
        return false;
    }
}