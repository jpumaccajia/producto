package com.nttdata.jpuma.producto.infraestructure.config.spring;

import com.nttdata.jpuma.producto.application.repository.AccountRepository;
import com.nttdata.jpuma.producto.application.repository.ClientRepository;
import com.nttdata.jpuma.producto.application.repository.ProductRepository;
import com.nttdata.jpuma.producto.application.service.AccountService;
import com.nttdata.jpuma.producto.application.service.ClientService;
import com.nttdata.jpuma.producto.application.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootServiceConfig {
    @Bean
    public ProductService productoService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }

    @Bean
    public AccountService cuentaService(AccountRepository accountRepository) {
        return new AccountService(accountRepository);
    }

    @Bean
    public ClientService clienteService(ClientRepository clientRepository) {
        return new ClientService(clientRepository);
    }
}
