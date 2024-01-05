package com.codigo.practicahex.infraestructure.controller;

import com.codigo.practicahex.application.service.FacturaDetalleService;
import com.codigo.practicahex.domain.models.FacturaCabecera;
import com.codigo.practicahex.domain.models.FacturaDetalle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/facturadetalle")
public class FacturaDetalleController {
    private final FacturaDetalleService facturaDetalleService;

    public FacturaDetalleController(FacturaDetalleService facturaDetalleService) {
        this.facturaDetalleService = facturaDetalleService;
    }
    @PostMapping
    public ResponseEntity<FacturaDetalle> create(@RequestBody FacturaDetalle facturaDetalle){
        FacturaDetalle createFacturaDetalle = facturaDetalleService.crearFacturaDetalle(facturaDetalle);
        return new ResponseEntity<>(createFacturaDetalle, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FacturaDetalle>> listarFacturaDetalle(){
        List<FacturaDetalle> facturasdet = facturaDetalleService.obtenerTodos();
        return new ResponseEntity<>(facturasdet, HttpStatus.OK);
    }

    @GetMapping("/{facturadetalleId}")
    public ResponseEntity<FacturaDetalle> getFacturaDetalle(@PathVariable Long facturadetalleId){
        return facturaDetalleService.getFacturaDetalle(facturadetalleId)
                .map(facturaDetalle -> new ResponseEntity<>(facturaDetalle, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{facturadetalleId}")
    public ResponseEntity<FacturaDetalle> updateFacturaDetalle(@PathVariable Long facturadetalleId, @RequestBody FacturaDetalle facturaDetalle){
        return facturaDetalleService.actualizarFacturaDetalle(facturadetalleId, facturaDetalle)
                .map(per -> new ResponseEntity<>(per, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{facturadetalleId}")
    public ResponseEntity<Void> deleteFacturaDetalleById(@PathVariable Long facturadetalleId){
        if(facturaDetalleService.borrarFacturaDetalle(facturadetalleId)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
