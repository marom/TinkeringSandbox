package com.marom.spring5mvcrest.controllers;

import com.marom.spring5mvcrest.api.model.CustomerDto;
import com.marom.spring5mvcrest.api.model.CustomerListDto;
import com.marom.spring5mvcrest.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDto> getListOfCustomers(){

        return new ResponseEntity<>(new CustomerListDto(customerService.getAllCustomers()),
                HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createNewCustomer(@RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.createNewCustomer(customerDto),
                HttpStatus.CREATED);
    }

}
