package com.nttdata.jpuma.producto.domain;

import com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo.ClientEntity;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo.ProductEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account
{
    private String id;
    private ProductEntity producto;
    private ClientEntity cliente;
    private Double saldo;
}
