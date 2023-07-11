package com.nttdata.jpuma.producto.infraestructure.db.springdata.repository;

import com.nttdata.jpuma.producto.application.repository.AccountRepository;
import com.nttdata.jpuma.producto.application.repository.ClientRepository;
import com.nttdata.jpuma.producto.domain.Account;
import com.nttdata.jpuma.producto.domain.Client;
import com.nttdata.jpuma.producto.domain.Product;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.mapper.AccountEntityMapper;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.mapper.ClientEntityMapper;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientDboRepository implements ClientRepository {

    private final ClientEntityMapper clienteMapper;


    @Override
    public Mono<Client> findById(String id) {

        WebClient client = WebClient.create("http://localhost:8081/api/clients");

        return client.get()
                .uri("/{id}",id)
                .retrieve()
                .bodyToMono(Client.class);
    }

}

