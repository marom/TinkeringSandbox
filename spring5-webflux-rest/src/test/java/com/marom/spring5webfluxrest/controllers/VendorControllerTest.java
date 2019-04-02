package com.marom.spring5webfluxrest.controllers;

import com.marom.spring5webfluxrest.domain.Vendor;
import com.marom.spring5webfluxrest.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;

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

    @Test
    public void createVendor() {

        BDDMockito.given(vendorRepository.saveAll(any(Publisher.class))).willReturn(Flux.just(Vendor.builder().build()));

        Mono<Vendor> vendorToCreate = Mono.just(Vendor.builder().firstName("First name").build());

        webTestClient.post()
                .uri("/api/vendors")
                .body(vendorToCreate, Vendor.class)
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    public void updateVendor() {

        BDDMockito.given(vendorRepository.saveAll(any(Publisher.class))).willReturn(Flux.just(Vendor.builder().build()));

        Mono<Vendor> vendorToUpdate = Mono.just(Vendor.builder().firstName("First name").build());

        webTestClient.put()
                .uri("/api/vendors/someId")
                .body(vendorToUpdate, Vendor.class)
                .exchange()
                .expectStatus().isOk();
    }


    @Test
    public void patchVendor() {

        given(vendorRepository.findById(anyString()))
                .willReturn(Mono.just(Vendor.builder().firstName("some name").lastName("last").build()));

        given(vendorRepository.save(any(Vendor.class)))
                .willReturn(Mono.just(Vendor.builder().build()));

        Mono<Vendor> vendorToUpdate = Mono.just(Vendor.builder().firstName("First").build());

        webTestClient.patch()
                .uri("/api/vendors/asdfasdf")
                .body(vendorToUpdate, Vendor.class)
                .exchange()
                .expectStatus()
                .isOk();

        BDDMockito.verify(vendorRepository).save(any());
    }

    @Test
    public void patchVendorNoChanges() {

        given(vendorRepository.findById(anyString()))
                .willReturn(Mono.just(Vendor.builder().firstName("some name").lastName("last").build()));

        given(vendorRepository.save(any(Vendor.class)))
                .willReturn(Mono.just(Vendor.builder().build()));

        Mono<Vendor> vendorToUpdate = Mono.just(Vendor.builder().firstName("some name").lastName("last").build());

        webTestClient.patch()
                .uri("/api/vendors/asdfasdf")
                .body(vendorToUpdate, Vendor.class)
                .exchange()
                .expectStatus()
                .isOk();

        BDDMockito.verify(vendorRepository, never()).save(any());
    }
}
