package com.marom.spring5webfluxrest.controllers;

import com.marom.spring5webfluxrest.domain.Category;
import com.marom.spring5webfluxrest.repositories.CategoryRepository;
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

        given(categoryRepository.findAll()).willReturn(Flux.just(Category.builder().description("cat1").build(), Category.builder().description("cat2").build()));

        webTestClient.get().uri("/api/categories")
                .exchange()
                .expectBodyList(Category.class)
                .hasSize(2);
    }

    @Test
    public void findCategoryById() {

        given(categoryRepository.findById(anyString())).willReturn(Mono.just(Category.builder().description("cat1").build()));

        webTestClient.get().uri("/api/categories/33434344")
                .exchange()
                .expectBody(Category.class);
    }

    @Test
    public void createCategory() {

        given(categoryRepository.saveAll(any(Publisher.class))).willReturn(Flux.just(Category.builder().build()));

        Mono<Category> categoryMono = Mono.just(Category.builder().description("cat desc").build());

        webTestClient.post().uri("/api/categories")
                .body(categoryMono, Category.class)
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    public void updateCategory() {

        given(categoryRepository.save(any(Category.class)))
                .willReturn(Mono.just(Category.builder().build()));

        Mono<Category> catToUpdateMono = Mono.just(Category.builder().description("Some Cat").build());

        webTestClient.put()
                .uri("/api/categories/asdfasdf")
                .body(catToUpdateMono, Category.class)
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    public void patchCategory() {

        given(categoryRepository.findById(anyString()))
                .willReturn(Mono.just(Category.builder().build()));

        given(categoryRepository.save(any(Category.class)))
                .willReturn(Mono.just(Category.builder().build()));

        Mono<Category> catToUpdateMono = Mono.just(Category.builder().description("Some Cat").build());

        webTestClient.patch()
                .uri("/api/categories/asdfasdf")
                .body(catToUpdateMono, Category.class)
                .exchange()
                .expectStatus()
                .isOk();

        BDDMockito.verify(categoryRepository).save(any());
    }

    @Test
    public void patchCategoryWhenNoChanges() {

        given(categoryRepository.findById(anyString()))
                .willReturn(Mono.just(Category.builder().description("Some Cat").build()));

        Mono<Category> catToUpdateMono = Mono.just(Category.builder().description("Some Cat").build());

        webTestClient.patch()
                .uri("/api/categories/asdfasdf")
                .body(catToUpdateMono, Category.class)
                .exchange()
                .expectStatus()
                .isOk();

        BDDMockito.verify(categoryRepository, never()).save(any());
    }
}
