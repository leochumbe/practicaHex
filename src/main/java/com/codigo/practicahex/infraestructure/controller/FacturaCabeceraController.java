package com.codigo.practicahex.infraestructure.controller;

import com.codigo.practicahex.application.service.FacturaCabeceraService;
import com.codigo.practicahex.domain.models.FacturaCabecera;
import com.codigo.practicahex.domain.models.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/facturacabecera")
public class FacturaCabeceraController {
    private final FacturaCabeceraService facturaCabeceraService;

    public FacturaCabeceraController(FacturaCabeceraService facturaCabeceraService) {
        this.facturaCabeceraService = facturaCabeceraService;
    }

    @PostMapping
    public ResponseEntity<FacturaCabecera> create(@RequestBody FacturaCabecera facturaCabecera){
        FacturaCabecera createFacturaCabecera = facturaCabeceraService.crearFacturaCabecera(facturaCabecera);
        return new ResponseEntity<>(createFacturaCabecera, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FacturaCabecera>> listarFacturaCabecera(){
        List<FacturaCabecera> facturas = facturaCabeceraService.obtenerTodos();
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @GetMapping("/{facturacabeceraId}")
    public ResponseEntity<FacturaCabecera> getFacturaCabecera(@PathVariable Long facturacabeceraId){
        return facturaCabeceraService.getFacturaCabecera(facturacabeceraId)
                .map(facturaCabecera -> new ResponseEntity<>(facturaCabecera, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{facturacabeceraId}")
    public ResponseEntity<FacturaCabecera> updateFacturaCabecera(@PathVariable Long facturacabeceraId, @RequestBody FacturaCabecera facturaCabecera){
        return facturaCabeceraService.actualizarFacturaCabecera(facturacabeceraId, facturaCabecera)
                .map(per -> new ResponseEntity<>(per, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{facturacabeceraId}")
    public ResponseEntity<Void> deleteFacturaCabeceraById(@PathVariable Long facturacabeceraId){
        if(facturaCabeceraService.borrarFacturaCabecera(facturacabeceraId)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
