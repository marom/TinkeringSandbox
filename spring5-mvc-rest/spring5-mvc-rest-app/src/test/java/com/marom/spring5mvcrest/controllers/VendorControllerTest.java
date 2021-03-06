package com.marom.spring5mvcrest.controllers;

import com.marom.spring5mvcrest.api.model.VendorDto;
import com.marom.spring5mvcrest.api.model.VendorListDto;
import com.marom.spring5mvcrest.exceptions.ResourceNotFoundException;
import com.marom.spring5mvcrest.services.VendorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static com.marom.spring5mvcrest.controllers.AbstractRestControllerTest.asJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VendorControllerTest {

    @Mock
    VendorService vendorService;

    @InjectMocks
    VendorController vendorController;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(vendorController).build();
    }

    @Test
    public void getAllVendors() throws Exception {

        VendorDto vendorTasty = VendorDto.builder().name("Western Tasty Fruits Ltd.").vendorUrl("/api/vendors/1").build();
        VendorDto vendorExotic = VendorDto.builder().name("Exotic Fruits Company").vendorUrl("/api/vendors/2").build();
        VendorListDto vendorListDto = new VendorListDto(Arrays.asList(vendorTasty, vendorExotic));

        when(vendorService.getAllVendors()).thenReturn(vendorListDto);

        String result = mockMvc.perform(get("/api/vendors")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
                //.andExpect(jsonPath("$.vendors", hasSize(2)));
        System.out.println(result);
    }

    @Test
    public void getVendorById() throws ResourceNotFoundException, Exception {

        //given
        VendorDto vendorExotic = VendorDto.builder().name("Exotic Fruits Company").vendorUrl("/api/vendors/2").build();

        //when
        when(vendorService.getVendorById(anyLong())).thenReturn(vendorExotic);

        //then
        mockMvc.perform(get("/api/vendors/2")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Exotic Fruits Company")));
    }

    @Test
    public void createNewVendor() throws ResourceNotFoundException, Exception {

        //given
        VendorDto vendorExotic = VendorDto.builder().name("Exotic Fruits Company").vendorUrl("/api/vendors/2").build();

        //when
        when(vendorService.createNewVendor(vendorExotic)).thenReturn(vendorExotic);

        //then
        mockMvc.perform(post("/api/vendors")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(vendorExotic)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", equalTo("Exotic Fruits Company")))
                .andExpect(jsonPath("$.vendor_url", equalTo("/api/vendors/2")));

    }
}
