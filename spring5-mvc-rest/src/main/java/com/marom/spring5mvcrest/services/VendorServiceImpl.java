package com.marom.spring5mvcrest.services;

import com.marom.spring5mvcrest.api.mapper.VendorMapper;
import com.marom.spring5mvcrest.api.model.VendorDto;
import com.marom.spring5mvcrest.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private VendorRepository vendorRepository;
    private VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public List<VendorDto> getAllVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(vendor -> {
                    VendorDto vendorDto = vendorMapper.vendorToVendorDto(vendor);
                    vendorDto.setVendorUrl("/api/vendors/" + vendor.getId());
                    return vendorDto;
                })
                .collect(Collectors.toList());
    }
}
