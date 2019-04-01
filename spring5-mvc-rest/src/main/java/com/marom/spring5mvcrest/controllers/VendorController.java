package com.marom.spring5mvcrest.controllers;

import com.marom.spring5mvcrest.api.model.VendorDto;
import com.marom.spring5mvcrest.exceptions.ResourceNotFoundException;
import com.marom.spring5mvcrest.services.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "This is my Vendor Controller")
@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @ApiOperation(value = "This will get a list of vendors.", notes = "These are some notes about the API.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VendorDto> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping({"/{vendorId}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDto getVendorById(@PathVariable Long vendorId) throws ResourceNotFoundException {
        return vendorService.getVendorById(vendorId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDto createNewVendor(@RequestBody VendorDto vendorDto) throws ResourceNotFoundException {
        return vendorService.createNewVendor(vendorDto);
    }
}
