package com.nttdata.jpuma.producto.infraestructure.rest.spring.mapper;

import com.nttdata.jpuma.producto.domain.Account;
import com.nttdata.jpuma.producto.infraestructure.rest.spring.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto toDto (Account cuenta);

    Account toDomain(AccountDto cuentaDto);
}
