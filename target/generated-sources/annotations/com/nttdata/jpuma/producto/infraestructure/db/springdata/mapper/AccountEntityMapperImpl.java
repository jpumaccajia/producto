package com.nttdata.jpuma.producto.infraestructure.db.springdata.mapper;

import com.nttdata.jpuma.producto.domain.Account;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo.AccountEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-11T18:08:25-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Microsoft)"
)
@Component
public class AccountEntityMapperImpl implements AccountEntityMapper {

    @Override
    public Account toDomain(AccountEntity cuentaEntity) {
        if ( cuentaEntity == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( cuentaEntity.getId() );
        account.setProducto( cuentaEntity.getProducto() );
        account.setCliente( cuentaEntity.getCliente() );
        account.setSaldo( cuentaEntity.getSaldo() );

        return account;
    }

    @Override
    public AccountEntity toDbo(Account cuenta) {
        if ( cuenta == null ) {
            return null;
        }

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setId( cuenta.getId() );
        accountEntity.setProducto( cuenta.getProducto() );
        accountEntity.setCliente( cuenta.getCliente() );
        accountEntity.setSaldo( cuenta.getSaldo() );

        return accountEntity;
    }
}
