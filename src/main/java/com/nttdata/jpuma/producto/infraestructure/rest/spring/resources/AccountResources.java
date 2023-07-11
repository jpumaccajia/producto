package com.nttdata.jpuma.producto.infraestructure.rest.spring.resources;

import com.nttdata.jpuma.producto.application.service.AccountService;
import com.nttdata.jpuma.producto.application.service.ClientService;
import com.nttdata.jpuma.producto.application.service.ProductService;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.dto.AccountDto;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.dto.ClientDto;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.dto.ProductDto;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.mapper.AccountMapper;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.mapper.ClientMapper;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountResources {

    private final AccountService cuentaService;
    private final ClientService clienteService;
    private final ProductService productoService;

    private final AccountMapper cuentaMapper;
    private final ClientMapper clienteMapper;
    private final ProductMapper productoMapper;

    @GetMapping("/{id}")
    public Mono<AccountDto> getCuentaById(@PathVariable String id) {
        return cuentaService.getCuenta(id)
                .map(cuentaMapper::toDto);
    }

    @PostMapping
    public Mono<AccountDto> createCuenta(@RequestBody AccountDto accountDto) {

        return clienteService.getCliente(accountDto.getCliente().getId())
                .flatMap( cliente -> {
                    if(cliente == null) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe Cliente"));
                    } else {
                        accountDto.setCliente(clienteMapper.toDto(cliente));
                        return productoService.getProducto(accountDto.getProducto().getId())
                                .flatMap( producto -> {
                                    if(producto == null) {
                                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe Producto"));
                                    } else {
                                        accountDto.setProducto(productoMapper.toDto(producto));
                                        return cuentaService.saveCuenta(cuentaMapper.toDomain(accountDto))
                                                .map(cuentaMapper::toDto);
                                    }
                                });
                    }
                });

//        return cuentaService.saveCuenta(cuentaMapper.toDomain(accountDto))
//                .map(cuentaMapper::toDto);
    }

    @PutMapping
    public Mono<AccountDto> updateCuenta(@RequestBody AccountDto accountDto) {

        return cuentaService.existsCuentaById(accountDto.getId())
                .flatMap(existe -> {
                    if(!existe) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe Cuenta con el ID"));
                    } else {
                        return cuentaService.saveCuenta(cuentaMapper.toDomain(accountDto))
                                .map(cuentaMapper::toDto);
                    }
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCuenta(@PathVariable String id) {
        return cuentaService.deleteCuenta(id);
    }

    @GetMapping("/product/{id}/clients")
    public Flux<ClientDto> findClientesByProductId(@PathVariable String productoId) {
        return cuentaService.findClientesByProductId(productoId)
                .map(clienteMapper::toDto);
    }

    @GetMapping("/client/{id}/products")
    public Flux<ProductDto> findProductosByClientId(@PathVariable String clienteId) {
        return cuentaService.findProductosByClientId(clienteId)
                .map(productoMapper::toDto);
    }
}
