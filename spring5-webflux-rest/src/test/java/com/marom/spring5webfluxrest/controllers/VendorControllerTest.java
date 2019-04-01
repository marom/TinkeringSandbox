package com.marom.spring5webfluxrest.controllers;

import com.marom.spring5webfluxrest.domain.Vendor;
import com.marom.spring5webfluxrest.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.anyString;

public class VendorControllerTest {

    VendorRepository vendorRepository;

    VendorController vendorController;

    WebTestClient webTestClient;
    @Before
    public void setUp() throws Exception {
        vendorRepository = Mockito.mock(VendorRepository.class);
        vendorController = new VendorController(vendorRepository);
        webTestClient = WebTestClient.bindToController(vendorController).build();
    }

    @Test
    public void listAllVendors() {

        BDDMockito.given(vendorRepository.findAll()).willReturn(Flux.just(Vendor.builder().firstName("name1").build(), Vendor.builder().firstName("name2").build()));

        webTestClient.get()
                .uri("/api/vendors")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Vendor.class)
                .hasSize(2);
    }

    @Test
    public void getVendorById() {

        BDDMockito.given(vendorRepository.findById(anyString())).willReturn(Mono.just(Vendor.builder().firstName("name1").build()));

        webTestClient.get()
                .uri("/api/vendors/dfdfadfd")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Vendor.class);
    }
}
