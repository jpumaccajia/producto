package com.nttdata.jpuma.producto.infraestructure.config.spring;

import com.nttdata.jpuma.producto.application.repository.ProductRepository;
import com.nttdata.jpuma.producto.application.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootServiceConfig {
    @Bean
    public ProductService productoService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}
