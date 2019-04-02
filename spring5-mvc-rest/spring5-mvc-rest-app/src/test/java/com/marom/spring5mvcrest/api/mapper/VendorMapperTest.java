package com.marom.spring5mvcrest.api.mapper;

import com.marom.spring5mvcrest.api.model.VendorDto;
import com.marom.spring5mvcrest.domain.Vendor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendorMapperTest {

    VendorMapper vendorMapper = VendorMapper.INSTANCE;


    @Test
    public void vendorToVendorDtoMapper(){

        final Vendor vendor = new Vendor();
        vendor.setName("Western Tasty Fruits Ltd.");

        VendorDto vendorDto = vendorMapper.vendorToVendorDto(vendor);

        assertEquals(vendorDto.getName(), vendor.getName());
    }


    @Test
    public void vendorDtoToVendorMapper(){

        final VendorDto vendorDto = new VendorDto();
        vendorDto.setName("Exotic Fruits Company");

        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDto);

        assertEquals(vendor.getName(), vendorDto.getName());
    }

}
