package com.marom.spring5mvcrest.bootstrap;

import com.marom.spring5mvcrest.domain.Category;
import com.marom.spring5mvcrest.domain.Customer;
import com.marom.spring5mvcrest.domain.Vendor;
import com.marom.spring5mvcrest.repositories.CategoryRepository;
import com.marom.spring5mvcrest.repositories.CustomerRepository;
import com.marom.spring5mvcrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap  implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private VendorRepository vendorRepository;


    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) {

        loadCategories();
        loadCustomers();
        loadVendors();
    }

    private void loadCategories() {

        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);
    }

    private void loadCustomers() {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstName("Sam");
        customer2.setLastName("Axe");

        customerRepository.save(customer2);

        System.out.println("Customers Loaded: " + customerRepository.count());
    }

    private void loadVendors() {

        Vendor vendorTasty = Vendor.builder().id(1L).name("Western Tasty Fruits Ltd.").build();
        vendorRepository.save(vendorTasty);
        Vendor vendorExotic = Vendor.builder().id(2L).name("Exotic Fruits Company").build();
        vendorRepository.save(vendorExotic);
        Vendor vendorHome = Vendor.builder().id(3L).name("Home Fruits.").build();
        vendorRepository.save(vendorHome);
        Vendor vendorRed = Vendor.builder().id(4L).name("Red Tasty Fruits Company").build();
        vendorRepository.save(vendorRed);
    }
}
