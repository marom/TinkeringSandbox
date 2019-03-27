package com.marom.spring5mvcrest.api.mapper;

import com.marom.spring5mvcrest.api.model.CustomerDto;
import com.marom.spring5mvcrest.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto customerToCustomerDTO(Customer customer);
}
