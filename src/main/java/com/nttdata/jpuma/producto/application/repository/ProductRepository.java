package com.nttdata.jpuma.producto.application.repository;

import com.nttdata.jpuma.producto.domain.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {

    Flux<Product> findAll();

    Mono<Product> findById(String id);

    Mono<Product> save(Product producto);

    Mono<Void> deleteById(String id);

    Mono<Boolean> existsById(String id);

    Mono<Boolean> existsByNombreProducto(String nombreProducto);
}
