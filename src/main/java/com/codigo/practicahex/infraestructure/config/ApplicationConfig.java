package com.codigo.practicahex.infraestructure.config;

import com.codigo.practicahex.application.service.FacturaCabeceraService;
import com.codigo.practicahex.application.service.FacturaDetalleService;
import com.codigo.practicahex.application.service.ProductoService;
import com.codigo.practicahex.application.useCase.FacturaCabeceraServiceImpl;
import com.codigo.practicahex.application.useCase.FacturaDetalleServiceImpl;
import com.codigo.practicahex.application.useCase.ProductoServiceImpl;
import com.codigo.practicahex.domain.ports.out.FacturaCabeceraOut;
import com.codigo.practicahex.domain.ports.out.FacturaDetalleOut;
import com.codigo.practicahex.domain.ports.out.ProductoOut;
import com.codigo.practicahex.infraestructure.repository.FacturaCabeceraJPARepositoryAdapter;
import com.codigo.practicahex.infraestructure.repository.FacturaDetalleJPARepositoryAdapter;
import com.codigo.practicahex.infraestructure.repository.ProductoJPARepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public FacturaCabeceraService facturaCabeceraService(FacturaCabeceraOut facturaCabeceraOut){
        return new FacturaCabeceraService(new FacturaCabeceraServiceImpl(facturaCabeceraOut));
    }
    @Bean
    public FacturaCabeceraOut facturaCabeceraOut( FacturaCabeceraJPARepositoryAdapter jpaRepositoryAdapter){
        return jpaRepositoryAdapter;
    }
    @Bean
    public ProductoService productoService(ProductoOut productoOut){
        return new ProductoService((new ProductoServiceImpl(productoOut)));
    }
    @Bean
    public ProductoOut productoOut(ProductoJPARepositoryAdapter productoJPARepositoryAdapter){
        return productoJPARepositoryAdapter;
    }
    @Bean
    public FacturaDetalleService facturaDetalleService(FacturaDetalleOut facturaDetalleOut){
        return new FacturaDetalleService((new FacturaDetalleServiceImpl(facturaDetalleOut)));
    }
    @Bean
    public FacturaDetalleOut facturaDetalleOut(FacturaDetalleJPARepositoryAdapter facturaDetalleJPARepositoryAdapter){
        return facturaDetalleJPARepositoryAdapter;
    }
}