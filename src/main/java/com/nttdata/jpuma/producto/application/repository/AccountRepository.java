package com.nttdata.jpuma.producto.application.repository;

import com.nttdata.jpuma.producto.domain.Account;
import com.nttdata.jpuma.producto.domain.Client;
import com.nttdata.jpuma.producto.domain.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository {

    Mono<Account> findById(String id);

    Mono<Account> save(Account cuenta);

    Mono<Void> deleteById(String id);

    Flux<Client> findClientsByProductId(String productoId);

    Flux<Product> findProductsByClientId(String ClienteId);

    Mono<Boolean> existsById(String id);
}
