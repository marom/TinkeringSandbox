package com.marom.spring5mvcrest.services;

import com.marom.spring5mvcrest.api.model.VendorDto;
import com.marom.spring5mvcrest.exceptions.ResourceNotFoundException;

import java.util.List;

public interface VendorService {

    List<VendorDto> getAllVendors();

    VendorDto getVendorById(Long vendorId) throws ResourceNotFoundException;

    VendorDto createNewVendor(VendorDto vendorDto) throws ResourceNotFoundException;
}
