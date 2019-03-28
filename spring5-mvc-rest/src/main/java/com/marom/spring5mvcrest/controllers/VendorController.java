package com.marom.spring5mvcrest.controllers;

import com.marom.spring5mvcrest.api.model.VendorDto;
import com.marom.spring5mvcrest.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VendorDto> getAllVendors() {
        return vendorService.getAllVendors();
    }
}
