package com.marom.spring5webfluxrest.controllers;

import com.marom.spring5webfluxrest.domain.Category;
import com.marom.spring5webfluxrest.repositories.CategoryRepository;
import org.reactivestreams.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/api/categories")
    public Flux<Category> listAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/api/categories/{id}")
    public Mono<Category> findCategoryById(@PathVariable String id) {
        return categoryRepository.findById(id);
    }

    @PostMapping("/api/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> createCategory(@RequestBody Publisher<Category> categoryStream) {
        return categoryRepository.saveAll(categoryStream).then();
    }


    @PutMapping("/api/categories/{categoryId}")
    public Mono<Category> updateCategory(@PathVariable String categoryId, @RequestBody Category category) {
        category.setId(categoryId);
        return categoryRepository.save(category);
    }
}
