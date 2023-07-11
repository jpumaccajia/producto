package com.nttdata.jpuma.producto.application.service;

import com.nttdata.jpuma.producto.application.repository.AccountRepository;
import com.nttdata.jpuma.producto.application.repository.ProductRepository;
import com.nttdata.jpuma.producto.domain.Account;
import com.nttdata.jpuma.producto.domain.Client;
import com.nttdata.jpuma.producto.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;

    public Mono<Account> getCuenta(String id) {
        return accountRepository.findById(id);
    }

    public Mono<Account> saveCuenta(Account cuenta) {
        return accountRepository.save(cuenta);
    }

    public Mono<Void> deleteCuenta(String id) {
        return accountRepository.deleteById(id);
    }

    public Mono<Boolean> existsCuentaById(String id) {
        return accountRepository.existsById(id);
    }

    public Flux<Client> findClientesByProductId(String clienteId) {
        return accountRepository.findClientsByProductId(clienteId);
    }

    public Flux<Product> findProductosByClientId(String productoId) {
        return accountRepository.findProductsByClientId(productoId);
    }

}
