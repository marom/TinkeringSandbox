package com.marom.spring5mvcrest.services;

import com.marom.spring5mvcrest.api.mapper.VendorMapper;
import com.marom.spring5mvcrest.api.model.VendorDto;
import com.marom.spring5mvcrest.api.model.VendorListDto;
import com.marom.spring5mvcrest.domain.Vendor;
import com.marom.spring5mvcrest.exceptions.ResourceNotFoundException;
import com.marom.spring5mvcrest.repositories.VendorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VendorServiceImplTest {

   @Mock
   private VendorRepository repository;

   private VendorMapper vendorMapper = VendorMapper.INSTANCE;

   @InjectMocks
   VendorService vendorService = new VendorServiceImpl(repository, vendorMapper);

    @Test
    public void getAllVendors() {
        //given
        final List<Vendor> vendors = createVendors();

        //when
        when(repository.findAll()).thenReturn(vendors);

        final VendorListDto allVendors = vendorService.getAllVendors();

        //then
        assertThat(allVendors.getVendors(), hasSize(2));
    }

    @Test public void getVendorById() throws ResourceNotFoundException {

        //given
        Vendor vendorTasty = Vendor.builder().id(1L).name("Western Tasty Fruits Ltd.").build();

        //when
        when(repository.findById(anyLong())).thenReturn(Optional.of(vendorTasty));

        VendorDto vendorDto = vendorService.getVendorById(1L);

        //then
        assertEquals(vendorDto.getName(), vendorTasty.getName());

    }

    @Test
    public void createNewVendor() throws ResourceNotFoundException {

        //given
        Vendor vendorTasty = Vendor.builder().id(1L).name("Western Tasty Fruits Ltd.").build();
        VendorDto vendorTastyDto = VendorDto.builder().name("Western Tasty Fruits Ltd.").build();

        //when
        when(repository.save(ArgumentMatchers.any(Vendor.class))).thenReturn(vendorTasty);

        VendorDto vendorDto = vendorService.createNewVendor(vendorTastyDto);

        //then
        assertEquals(vendorDto.getName(), vendorTasty.getName());
        assertEquals(vendorDto.getVendorUrl(), "/api/vendors/1");

    }

    private List<Vendor> createVendors(){
        List<Vendor> vendors = new ArrayList<>();
        Vendor vendorTasty = Vendor.builder().id(1L).name("Western Tasty Fruits Ltd.").build();
        Vendor vendorExotic = Vendor.builder().id(2L).name("Exotic Fruits Company").build();
        vendors.add(vendorTasty);
        vendors.add(vendorExotic);
        return vendors;
    }

    private List<VendorDto> createVendorsDto(){
        List<VendorDto> vendorDtos = new ArrayList<>();
        VendorDto vendorTasty = VendorDto.builder().name("Western Tasty Fruits Ltd.").vendorUrl("/api/vendors/1").build();
        VendorDto vendorExotic = VendorDto.builder().name("Exotic Fruits Company").vendorUrl("/api/vendors/2").build();
        vendorDtos.add(vendorTasty);
        vendorDtos.add(vendorExotic);
        return vendorDtos;
    }
}
