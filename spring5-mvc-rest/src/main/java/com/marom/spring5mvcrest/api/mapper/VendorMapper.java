package com.marom.spring5mvcrest.api.mapper;

import com.marom.spring5mvcrest.api.model.VendorDto;
import com.marom.spring5mvcrest.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDto vendorToVendorDto(Vendor vendor);

    Vendor vendorDtoToVendor(VendorDto vendorDto);
}
