package com.nttdata.jpuma.producto.infraestructure.rest.spring.mapper;

import com.nttdata.jpuma.producto.domain.Product;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto (Product producto);

    Product toDomain(ProductDto productoDto);
}
