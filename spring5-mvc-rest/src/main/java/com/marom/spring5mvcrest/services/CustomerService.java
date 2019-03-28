package com.marom.spring5mvcrest.services;

import com.marom.spring5mvcrest.api.model.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Long id);

    CustomerDto createNewCustomer(CustomerDto customerDto);

    CustomerDto replaceExistingCustomer(Long customerId, CustomerDto customerDto);
}
