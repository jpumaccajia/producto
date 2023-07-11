package com.nttdata.jpuma.producto.infraestructure.db.springdata.mapper;

import com.nttdata.jpuma.producto.domain.Account;
import com.nttdata.jpuma.producto.infraestructure.db.springdata.dbo.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountEntityMapper {

    Account toDomain(AccountEntity cuentaEntity);
    AccountEntity toDbo(Account cuenta);
}
