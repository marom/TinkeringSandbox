package com.marom.spring5webfluxrest.bootstrap;

import com.marom.spring5webfluxrest.domain.Category;
import com.marom.spring5webfluxrest.domain.Vendor;
import com.marom.spring5webfluxrest.repositories.CategoryRepository;
import com.marom.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private VendorRepository vendorRepository;
    private CategoryRepository categoryRepository;

    public Bootstrap(VendorRepository vendorRepository, CategoryRepository categoryRepository) {
        this.vendorRepository = vendorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadVendors();
    }

    private void loadVendors() {

      if (vendorRepository.count().block() == 0) {

          vendorRepository.save(Vendor.builder()
                  .firstName("Joe")
                  .lastName("Buck").build()).block();

          vendorRepository.save(Vendor.builder()
                  .firstName("Micheal")
                  .lastName("Weston").build()).block();

          vendorRepository.save(Vendor.builder()
                  .firstName("Jessie")
                  .lastName("Waters").build()).block();

          vendorRepository.save(Vendor.builder()
                  .firstName("Bill")
                  .lastName("Nershi").build()).block();

          vendorRepository.save(Vendor.builder()
                  .firstName("Jimmy")
                  .lastName("Buffett").build()).block();

          System.out.println("Loaded Vendors: " + vendorRepository.count().block());
        }
    }

    private void loadCategories() {

        if (categoryRepository.count().block() == 0) {

            //load data
            categoryRepository.save(Category.builder()
                    .description("Fruits").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Nuts").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Breads").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Meats").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Eggs").build()).block();

            System.out.println("Loaded Categories: " + categoryRepository.count().block());
        }

    }
}
