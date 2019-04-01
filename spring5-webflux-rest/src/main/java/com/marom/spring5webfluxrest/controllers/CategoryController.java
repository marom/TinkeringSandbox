package com.marom.spring5webfluxrest.controllers;

import com.marom.spring5webfluxrest.domain.Category;
import com.marom.spring5webfluxrest.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
}
