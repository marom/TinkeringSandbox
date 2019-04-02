package com.marom.spring5mvcrest.services;

import com.marom.spring5mvcrest.api.mapper.VendorMapper;
import com.marom.spring5mvcrest.api.model.VendorDto;
import com.marom.spring5mvcrest.api.model.VendorListDto;
import com.marom.spring5mvcrest.domain.Vendor;
import com.marom.spring5mvcrest.exceptions.ResourceNotFoundException;
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
    public VendorListDto getAllVendors() {
        List<VendorDto> vendorDtos = vendorRepository.findAll()
                .stream()
                .map(vendor -> {
                    VendorDto vendorDto = vendorMapper.vendorToVendorDto(vendor);
                    vendorDto.setVendorUrl("/api/vendors/" + vendor.getId());
                    return vendorDto;
                })
                .collect(Collectors.toList());

        return new VendorListDto(vendorDtos);
    }

    @Override
    public VendorDto getVendorById(Long vendorId) throws ResourceNotFoundException {

        return vendorRepository.findById(vendorId)
                .map(vendorMapper::vendorToVendorDto)
                .map(vendorDto -> {
                    vendorDto.setVendorUrl(getVendorUrl(vendorId));
                    return vendorDto;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public VendorDto createNewVendor(VendorDto vendorDto) {

        final Vendor mappedVendor = vendorMapper.vendorDtoToVendor(vendorDto);
        final Vendor vendor = vendorRepository.save(mappedVendor);

        final VendorDto returnedVendorDto = vendorMapper.vendorToVendorDto(vendor);
        returnedVendorDto.setVendorUrl(getVendorUrl(vendor.getId()));
        return returnedVendorDto;
    }

    private String getVendorUrl(Long id) {
        return "/api/vendors/" + id;
    }
}
