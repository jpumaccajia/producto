package com.nttdata.jpuma.producto.infraestructure.db.springdata.repository;

import com.nttdata.jpuma.producto.application.repository.AccountRepository;
import com.nttdata.jpuma.producto.domain.Account;
import com.nttdata.jpuma.producto.domain.Client;
import com.nttdata.jpuma.producto.domain.Product;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.mapper.AccountEntityMapper;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.mapper.ClientEntityMapper;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountDboRepository implements AccountRepository {

    private final SpringDataAccountRepository cuentaRepository;

    private final AccountEntityMapper cuentaMapper;
    private final ClientEntityMapper clienteMapper;
    private final ProductEntityMapper productoMapper;

    @Override
    public Mono<Account> findById(String id) {
        return cuentaRepository.findById(id)
                .map(cuentaMapper::toDomain);
    }

    @Override
    public Mono<Account> save(Account cuenta) {
        return cuentaRepository.save(cuentaMapper.toDbo(cuenta))
                .map(cuentaMapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return cuentaRepository.deleteById(id);
    }

    @Override
    public Flux<Client> findClientsByProductId(String productoId){
        return cuentaRepository.findClientsByProductId(productoId)
                .map(clienteMapper::toDomain);
    }

    @Override
    public Flux<Product> findProductsByClientId(String ClienteId){
        return cuentaRepository.findProductsByClientId(ClienteId)
                .map(productoMapper::toDomain);
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        return cuentaRepository.existsById(id);
    }
}

