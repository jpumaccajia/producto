package com.nttdata.jpuma.producto.application.repository;

import com.nttdata.jpuma.producto.domain.Client;
import reactor.core.publisher.Mono;

public interface ClientRepository {

    Mono<Client> findById(String id);

}
