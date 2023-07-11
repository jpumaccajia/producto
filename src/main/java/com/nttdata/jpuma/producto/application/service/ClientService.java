package com.nttdata.jpuma.producto.application.service;

import com.nttdata.jpuma.producto.application.repository.ClientRepository;
import com.nttdata.jpuma.producto.domain.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;

    public Mono<Client> getCliente(String id) {
        return clientRepository.findById(id);
    }

}
