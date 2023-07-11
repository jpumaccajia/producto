package com.nttdata.jpuma.producto.infraestructure.rest.spring.mapper;

import com.nttdata.jpuma.producto.domain.Product;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.dto.ProductDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-11T14:29:46-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Microsoft)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(Product producto) {
        if ( producto == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( producto.getId() );
        productDto.setTipoProducto( producto.getTipoProducto() );
        productDto.setNombreProducto( producto.getNombreProducto() );
        productDto.setComision( producto.getComision() );
        productDto.setNromovimientos( producto.getNromovimientos() );
        productDto.setCondicion( producto.getCondicion() );
        productDto.setTipoDisponibilidad( producto.getTipoDisponibilidad() );
        productDto.setDisponibilidad( producto.getDisponibilidad() );

        return productDto;
    }

    @Override
    public Product toDomain(ProductDto productoDto) {
        if ( productoDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productoDto.getId() );
        product.setTipoProducto( productoDto.getTipoProducto() );
        product.setNombreProducto( productoDto.getNombreProducto() );
        product.setComision( productoDto.getComision() );
        product.setNromovimientos( productoDto.getNromovimientos() );
        product.setCondicion( productoDto.getCondicion() );
        product.setTipoDisponibilidad( productoDto.getTipoDisponibilidad() );
        product.setDisponibilidad( productoDto.getDisponibilidad() );

        return product;
    }
}
