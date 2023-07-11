package com.nttdata.jpuma.producto.infraestructure.db.springdata.mapper;

import com.nttdata.jpuma.producto.domain.Product;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    Product toDomain(ProductEntity clienteEntity);
    ProductEntity toDbo(Product product);
}
