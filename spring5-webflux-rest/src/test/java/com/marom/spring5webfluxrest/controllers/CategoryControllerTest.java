package com.marom.spring5webfluxrest.controllers;

import com.marom.spring5webfluxrest.domain.Category;
import com.marom.spring5webfluxrest.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.anyString;

public class CategoryControllerTest {

    WebTestClient webTestClient;
    CategoryRepository categoryRepository;
    CategoryController categoryController;

    @Before
    public void setUp() {
        categoryRepository = Mockito.mock(CategoryRepository.class);
        categoryController = new CategoryController(categoryRepository);
        webTestClient = WebTestClient.bindToController(categoryController).build();
    }

    @Test
    public void listAllCategories() {

        BDDMockito.given(categoryRepository.findAll()).willReturn(Flux.just(Category.builder().description("cat1").build(), Category.builder().description("cat2").build()));

        webTestClient.get().uri("/api/categories")
                .exchange()
                .expectBodyList(Category.class)
                .hasSize(2);
    }

    @Test
    public void findCategoryById() {

        BDDMockito.given(categoryRepository.findById(anyString())).willReturn(Mono.just(Category.builder().description("cat1").build()));

        webTestClient.get().uri("/api/categories/33434344")
                .exchange()
                .expectBody(Category.class);
    }
}
