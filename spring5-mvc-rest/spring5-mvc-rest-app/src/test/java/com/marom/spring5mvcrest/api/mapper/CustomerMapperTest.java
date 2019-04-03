package com.marom.spring5mvcrest.api.mapper;


import com.marom.model.CustomerDto;
import com.marom.spring5mvcrest.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest {

    public static final String JIMMY = "Jimmy";
    public static final String FALLON = "Fallon";

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() {
        //given
        Customer customer = new Customer();
        customer.setFirstName(JIMMY);
        customer.setLastName(FALLON);

        //when
        CustomerDto customerDto = customerMapper.customerToCustomerDto(customer);

        //then
        assertEquals(JIMMY, customerDto.getFirstName());
        assertEquals(FALLON, customerDto.getLastName());

    }

}
