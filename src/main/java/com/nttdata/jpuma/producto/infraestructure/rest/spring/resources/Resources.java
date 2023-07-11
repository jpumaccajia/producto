package com.nttdata.jpuma.producto.infraestructure.rest.spring.resources;

import com.nttdata.jpuma.producto.application.service.ProductService;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.dto.ProductDto;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class Resources {

    private final ProductService productoService;

    private final ProductMapper productoMapper;


    @GetMapping
    public Flux<ProductDto> getAllProductos() {
        return productoService.getProductos()
                .map(productoMapper::toDto);
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProductoById(@PathVariable String id) {
        return productoService.getProducto(id)
                .map(productoMapper::toDto);
    }

    @PostMapping
    public Mono<ProductDto> createProducto(@RequestBody ProductDto productDto) {
        return productoService.existsProductoByNombreProducto(productDto.getNombreProducto())
                .flatMap(existe -> {
                    if(existe) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existe un producto con el mismo nombre"));
                    } else {
                        return productoService.saveProducto(productoMapper.toDomain(productDto))
                                .map(productoMapper::toDto);
                    }
                });
    }

    @PutMapping
    public Mono<ProductDto> updateProducto(@RequestBody ProductDto productDto) {

        return productoService.existsProductoById(productDto.getId())
                .flatMap(existe -> {
                    if(!existe) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe un Producto con el ID"));
                    } else {
                        return productoService.saveProducto(productoMapper.toDomain(productDto))
                                .map(productoMapper::toDto);
                    }
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProducto(@PathVariable String id) {
        return productoService.deleteProducto(id);
    }
}
