package com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Document(collection = "cuenta")
public class AccountEntity {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductEntity producto;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClientEntity cliente;
}
