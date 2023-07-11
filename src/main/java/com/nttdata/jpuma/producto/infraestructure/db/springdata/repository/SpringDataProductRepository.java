package com.nttdata.jpuma.producto.infraestructure.db.springdata.repository;

import com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo.ProductEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface SpringDataProductRepository extends ReactiveMongoRepository<ProductEntity, String> {
    Mono<Boolean> existsById(String id);
    Mono<Boolean> existsByNombreProducto(String nombreProducto);

}
