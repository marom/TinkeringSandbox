package com.marom.spring5mvcrest.services;

import com.marom.model.CustomerDto;
import com.marom.spring5mvcrest.api.mapper.CustomerMapper;
import com.marom.spring5mvcrest.domain.Customer;
import com.marom.spring5mvcrest.exceptions.ResourceNotFoundException;
import com.marom.spring5mvcrest.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    CustomerService customerService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(customerMapper, customerRepository);
    }

    @Test
    public void getAllCustomers() {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstName("Sam");
        customer2.setLastName("Axe");

        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        //when
        List<CustomerDto> customerDTOS = customerService.getAllCustomers();

        //then
        assertEquals(2, customerDTOS.size());

    }

    @Test
    public void getCustomerById() throws ResourceNotFoundException {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");

        when(customerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(customer1));

        //when
        CustomerDto customerDto = customerService.getCustomerById(1L);

        assertEquals("Michale", customerDto.getFirstName());
    }


    @Test
    public void createNewCustomer() {

        //given
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName("Jim");

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstName(customerDto.getFirstName());
        savedCustomer.setLastName(customerDto.getLastName());
        savedCustomer.setId(1l);

        when(customerRepository.save(ArgumentMatchers.any(Customer.class))).thenReturn(savedCustomer);

        //when
        CustomerDto savedDto = customerService.createNewCustomer(customerDto);

        //then
        assertEquals(customerDto.getFirstName(), savedDto.getFirstName());
        assertEquals("/api/customers/1", savedDto.getCustomerUrl());
    }

    @Test
    public void replaceExistingCustomer() {

        //given
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName("Jim");
        customerDto.setLastName("President");

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstName(customerDto.getFirstName());
        savedCustomer.setLastName(customerDto.getLastName());
        savedCustomer.setId(1l);

        when(customerRepository.save(ArgumentMatchers.any(Customer.class))).thenReturn(savedCustomer);

        //when
        CustomerDto savedDto = customerService.replaceExistingCustomer(savedCustomer.getId(), customerDto);

        //then
        assertEquals(customerDto.getFirstName(), savedDto.getFirstName());
        assertEquals(customerDto.getLastName(), savedDto.getLastName());
        assertEquals("/api/customers/1", savedDto.getCustomerUrl());
    }
}
