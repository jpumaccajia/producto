package com.nttdata.jpuma.producto.infraestructure.rest.spring.mapper;

import com.nttdata.jpuma.producto.domain.Account;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo.ClientEntity;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo.ProductEntity;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.dto.AccountDto;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.dto.ClientDto;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.dto.ProductDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-11T16:55:27-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Microsoft)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto toDto(Account cuenta) {
        if ( cuenta == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setId( cuenta.getId() );
        accountDto.setProducto( productEntityToProductDto( cuenta.getProducto() ) );
        accountDto.setCliente( clientEntityToClientDto( cuenta.getCliente() ) );

        return accountDto;
    }

    @Override
    public Account toDomain(AccountDto cuentaDto) {
        if ( cuentaDto == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( cuentaDto.getId() );
        account.setProducto( productDtoToProductEntity( cuentaDto.getProducto() ) );
        account.setCliente( clientDtoToClientEntity( cuentaDto.getCliente() ) );

        return account;
    }

    protected ProductDto productEntityToProductDto(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( productEntity.getId() );
        productDto.setTipoProducto( productEntity.getTipoProducto() );
        productDto.setNombreProducto( productEntity.getNombreProducto() );
        productDto.setComision( productEntity.getComision() );
        productDto.setNromovimientos( productEntity.getNromovimientos() );
        productDto.setCondicion( productEntity.getCondicion() );
        productDto.setTipoDisponibilidad( productEntity.getTipoDisponibilidad() );
        productDto.setDisponibilidad( productEntity.getDisponibilidad() );

        return productDto;
    }

    protected ClientDto clientEntityToClientDto(ClientEntity clientEntity) {
        if ( clientEntity == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setId( clientEntity.getId() );
        clientDto.setNombreCompleto( clientEntity.getNombreCompleto() );
        clientDto.setTipoDocumento( clientEntity.getTipoDocumento() );
        clientDto.setNroDocumento( clientEntity.getNroDocumento() );
        clientDto.setDireccion( clientEntity.getDireccion() );
        clientDto.setTelefono( clientEntity.getTelefono() );
        clientDto.setEmail( clientEntity.getEmail() );
        clientDto.setCategoria( clientEntity.getCategoria() );

        return clientDto;
    }

    protected ProductEntity productDtoToProductEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( productDto.getId() );
        productEntity.setTipoProducto( productDto.getTipoProducto() );
        productEntity.setNombreProducto( productDto.getNombreProducto() );
        productEntity.setComision( productDto.getComision() );
        productEntity.setNromovimientos( productDto.getNromovimientos() );
        productEntity.setCondicion( productDto.getCondicion() );
        productEntity.setTipoDisponibilidad( productDto.getTipoDisponibilidad() );
        productEntity.setDisponibilidad( productDto.getDisponibilidad() );

        return productEntity;
    }

    protected ClientEntity clientDtoToClientEntity(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId( clientDto.getId() );
        clientEntity.setNombreCompleto( clientDto.getNombreCompleto() );
        clientEntity.setTipoDocumento( clientDto.getTipoDocumento() );
        clientEntity.setNroDocumento( clientDto.getNroDocumento() );
        clientEntity.setDireccion( clientDto.getDireccion() );
        clientEntity.setTelefono( clientDto.getTelefono() );
        clientEntity.setEmail( clientDto.getEmail() );
        clientEntity.setCategoria( clientDto.getCategoria() );

        return clientEntity;
    }
}
