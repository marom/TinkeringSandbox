package com.marom.spring5webfluxrest.controllers;

import com.marom.spring5webfluxrest.domain.Vendor;
import com.marom.spring5webfluxrest.repositories.VendorRepository;
import org.reactivestreams.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VendorController {

    private final VendorRepository vendorRepository;

    public VendorController(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }


    @GetMapping("/api/vendors")
    public Flux<Vendor> listAllVendors() {
        return vendorRepository.findAll();
    }

    @GetMapping("/api/vendors/{id}")
    public Mono<Vendor> getVendorById(@PathVariable String id) {
        return vendorRepository.findById(id);
    }

    @PostMapping("/api/vendors")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> createVendor(@RequestBody Publisher<Vendor> vendorPublisher) {
        return vendorRepository.saveAll(vendorPublisher).then();
    }

    @PutMapping("/api/vendors/{id}")
    public Mono<Vendor> updateVendor(@PathVariable String id, @RequestBody Vendor vendor) {
        vendor.setId(id);
        return vendorRepository.save(vendor);
    }

    @PatchMapping("/api/vendors/{vendorId}")
    public Mono<Vendor> patchVendor(@PathVariable String vendorId, @RequestBody Vendor vendor) {

        Vendor foundVendor = vendorRepository.findById(vendorId).block();
        boolean changed = false;

        if (!foundVendor.getFirstName().equals(vendor.getFirstName())) {
            foundVendor.setFirstName(vendor.getFirstName());
            changed = true;
        }
        if (!foundVendor.getLastName().equals(vendor.getLastName())) {
            foundVendor.setLastName(vendor.getLastName());
            changed = true;
        }

        if (changed) {
            return vendorRepository.save(foundVendor);
        }
        return Mono.just(foundVendor);
    }
}
