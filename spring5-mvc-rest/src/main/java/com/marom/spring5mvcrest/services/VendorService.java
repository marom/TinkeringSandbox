package com.marom.spring5mvcrest.services;

import com.marom.spring5mvcrest.api.model.VendorDto;
import com.marom.spring5mvcrest.api.model.VendorListDto;
import com.marom.spring5mvcrest.exceptions.ResourceNotFoundException;

public interface VendorService {

    VendorListDto getAllVendors();

    VendorDto getVendorById(Long vendorId) throws ResourceNotFoundException;

    VendorDto createNewVendor(VendorDto vendorDto) throws ResourceNotFoundException;
}
