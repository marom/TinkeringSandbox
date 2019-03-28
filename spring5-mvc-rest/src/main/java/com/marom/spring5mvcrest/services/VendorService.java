package com.marom.spring5mvcrest.services;

import com.marom.spring5mvcrest.api.model.VendorDto;

import java.util.List;

public interface VendorService {

    List<VendorDto> getAllVendors();
}
