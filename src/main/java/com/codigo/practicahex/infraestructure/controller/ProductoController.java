package com.codigo.practicahex.infraestructure.controller;

import com.codigo.practicahex.application.service.ProductoService;
import com.codigo.practicahex.domain.models.Producto;
import com.codigo.practicahex.infraestructure.entity.ProductoEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/producto")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto){
        Producto createProducto = productoService.crearProducto(producto);
        return new ResponseEntity<>(createProducto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos(){
        List<Producto> productos = productoService.obtenerTodos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<Producto> getProducto(@PathVariable Long productoId){
        return productoService.getProducto(productoId)
                .map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @PutMapping("/{productoId}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long productoId, @RequestBody Producto producto){
        return productoService.actualizarProducto(productoId, producto)
                .map(pro -> new ResponseEntity<>(pro, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> deleteProductoById(@PathVariable Long productoId){
        if(productoService.borrarProducto(productoId)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
