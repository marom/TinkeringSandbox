package com.marom.spring5mvcrest.services;

import com.marom.model.CustomerDto;
import com.marom.spring5mvcrest.api.mapper.CustomerMapper;
import com.marom.spring5mvcrest.domain.Customer;
import com.marom.spring5mvcrest.exceptions.ResourceNotFoundException;
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
                    com.marom.model.CustomerDto customerDto = customerMapper.customerToCustomerDto(customer);
                    customerDto.setCustomerUrl("/api/customers/" + customer.getId());
                    return customerDto;
                })
               .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Long id) throws ResourceNotFoundException {
        return customerRepository.findById(id)
                .map(customerMapper::customerToCustomerDto)
                .map(customerDTO -> {
                    //set API URL
                    customerDTO.setCustomerUrl(getCustomerUrl(id));
                    return customerDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public CustomerDto createNewCustomer(CustomerDto customerDto) {

        Customer customer = customerMapper.customerDtoToCustomer(customerDto);

        Customer savedCustomer = customerRepository.save(customer);

        CustomerDto returnDto = customerMapper.customerToCustomerDto(savedCustomer);

        returnDto.setCustomerUrl("/api/customers/" + savedCustomer.getId());

        return returnDto;
    }

    @Override
    public CustomerDto replaceExistingCustomer(Long customerId, CustomerDto customerDto) {

        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
        customer.setId(customerId);

        Customer savedCustomer = customerRepository.save(customer);

        CustomerDto returnDto = customerMapper.customerToCustomerDto(savedCustomer);
        returnDto.setCustomerUrl("/api/customers/" + savedCustomer.getId());

        return returnDto;
    }

    @Override
    public CustomerDto patchCustomer(Long id, CustomerDto customerDto) throws ResourceNotFoundException {
        return customerRepository.findById(id).map(customer -> {

            if(customerDto.getFirstName() != null){
                customer.setFirstName(customerDto.getFirstName());
            }

            if(customerDto.getLastName() != null){
                customer.setLastName(customerDto.getLastName());
            }

            CustomerDto returnDto = customerMapper.customerToCustomerDto(customerRepository.save(customer));

            returnDto.setCustomerUrl("/api/customer/" + id);

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    private String getCustomerUrl(Long id) {
        return "/api/customer/" + id;
    }
}
