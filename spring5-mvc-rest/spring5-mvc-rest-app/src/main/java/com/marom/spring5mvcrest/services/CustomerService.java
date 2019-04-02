package com.marom.spring5mvcrest.services;

import com.marom.spring5mvcrest.api.model.CustomerDto;
import com.marom.spring5mvcrest.exceptions.ResourceNotFoundException;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Long id) throws ResourceNotFoundException;

    CustomerDto createNewCustomer(CustomerDto customerDto);

    CustomerDto replaceExistingCustomer(Long customerId, CustomerDto customerDto);

    CustomerDto patchCustomer(Long id, CustomerDto customerDto) throws ResourceNotFoundException;

    void deleteCustomerById(Long id);
}
