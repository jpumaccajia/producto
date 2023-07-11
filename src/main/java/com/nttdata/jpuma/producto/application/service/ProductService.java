package com.nttdata.jpuma.producto.application.service;

import com.nttdata.jpuma.producto.application.repository.ProductRepository;
import com.nttdata.jpuma.producto.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public Flux<Product> getProductos() {
        return productRepository.findAll();
    }
    public Mono<Product> getProducto(String id) {
        return productRepository.findById(id);
    }

    public Mono<Product> saveProducto(Product producto) {
        return productRepository.save(producto);
    }

    public Mono<Void> deleteProducto(String id) {
        return productRepository.deleteById(id);
    }

    public Mono<Boolean> existsProductoById(String id) {
        return productRepository.existsById(id);
    }

    public Mono<Boolean> existsProductoByNombreProducto(String nombreProducto) {
        return productRepository.existsByNombreProducto(nombreProducto);
    }

}
