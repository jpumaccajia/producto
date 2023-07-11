package com.nttdata.jpuma.producto.infraestructure.rest.spring.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String id;
    private ProductDto producto;
    private ClientDto cliente;
}
