package com.nttdata.jpuma.producto.infraestructure.db.springdata.mapper;

import com.nttdata.jpuma.producto.domain.Product;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo.ProductEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-11T16:55:27-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Microsoft)"
)
@Component
public class ProductEntityMapperImpl implements ProductEntityMapper {

    @Override
    public Product toDomain(ProductEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( clienteEntity.getId() );
        product.setTipoProducto( clienteEntity.getTipoProducto() );
        product.setNombreProducto( clienteEntity.getNombreProducto() );
        product.setComision( clienteEntity.getComision() );
        product.setNromovimientos( clienteEntity.getNromovimientos() );
        product.setCondicion( clienteEntity.getCondicion() );
        product.setTipoDisponibilidad( clienteEntity.getTipoDisponibilidad() );
        product.setDisponibilidad( clienteEntity.getDisponibilidad() );

        return product;
    }

    @Override
    public ProductEntity toDbo(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( product.getId() );
        productEntity.setTipoProducto( product.getTipoProducto() );
        productEntity.setNombreProducto( product.getNombreProducto() );
        productEntity.setComision( product.getComision() );
        productEntity.setNromovimientos( product.getNromovimientos() );
        productEntity.setCondicion( product.getCondicion() );
        productEntity.setTipoDisponibilidad( product.getTipoDisponibilidad() );
        productEntity.setDisponibilidad( product.getDisponibilidad() );

        return productEntity;
    }
}
