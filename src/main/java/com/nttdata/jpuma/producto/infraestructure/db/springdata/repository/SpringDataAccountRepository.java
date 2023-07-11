package com.nttdata.jpuma.producto.infraestructure.db.springdata.repository;

import com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo.AccountEntity;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo.ClientEntity;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo.ProductEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SpringDataAccountRepository extends ReactiveMongoRepository<AccountEntity, String> {
    Mono<Boolean> existsById(String id);

    @Query("{ 'producto.id' : ?0 }")
    Flux<ClientEntity> findClientsByProductId(String productoId);

    @Query("{ 'cliente.id' : ?0 }")
    Flux<ProductEntity> findProductsByClientId(String clienteId);

}
