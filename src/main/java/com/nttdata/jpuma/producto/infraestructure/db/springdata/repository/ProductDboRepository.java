package com.nttdata.jpuma.producto.infraestructure.db.springdata.repository;

import com.nttdata.jpuma.producto.application.repository.ProductRepository;
import com.nttdata.jpuma.producto.domain.Product;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.mapper.ClientEntityMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductDboRepository implements ProductRepository {

    private final SpringDataProductRepository productoRepository;

    private final ClientEntityMapper clienteMapper;

    @Override
    public Flux<Product> findAll(){
        return productoRepository.findAll()
                .map(clienteMapper::toDomain);
    }
    @Override
    public Mono<Product> findById(String id) {
        return productoRepository.findById(id)
                .map(clienteMapper::toDomain);
    }

    @Override
    public Mono<Product> save(Product producto) {
        return productoRepository.save(clienteMapper.toDbo(producto))
                .map(clienteMapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return productoRepository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        return productoRepository.existsById(id);
    }

    @Override
    public Mono<Boolean> existsByNombreProducto(String nombreProducto) {
        return productoRepository.existsByNombreProducto(nombreProducto);
    }

}

