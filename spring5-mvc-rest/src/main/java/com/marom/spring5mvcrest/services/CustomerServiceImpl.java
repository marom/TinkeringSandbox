package com.marom.spring5mvcrest.services;

import com.marom.spring5mvcrest.api.mapper.CustomerMapper;
import com.marom.spring5mvcrest.api.model.CustomerDto;
import com.marom.spring5mvcrest.domain.Customer;
import com.marom.spring5mvcrest.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }


    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customer -> {
                    CustomerDto customerDto = customerMapper.customerToCustomerDto(customer);
                    customerDto.setCustomerUrl("/api/customers/" + customer.getId());
                    return customerDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::customerToCustomerDto)
                .orElseThrow(RuntimeException::new); //todo implement better exception handling
    }

    @Override
    public CustomerDto createNewCustomer(CustomerDto customerDto) {

        Customer customer = customerMapper.customerDtoToCustomer(customerDto);

        Customer savedCustomer = customerRepository.save(customer);

        CustomerDto returnDto = customerMapper.customerToCustomerDto(savedCustomer);

        returnDto.setCustomerUrl("/api/customers/" + savedCustomer.getId());

        return returnDto;
    }
}
