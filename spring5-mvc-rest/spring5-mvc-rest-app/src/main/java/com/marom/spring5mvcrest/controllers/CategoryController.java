package com.marom.spring5mvcrest.controllers;

import com.marom.spring5mvcrest.api.model.CategoryDto;
import com.marom.spring5mvcrest.api.model.CategoryListDto;
import com.marom.spring5mvcrest.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDto getAllCategories(){

        return new CategoryListDto(categoryService.getAllCategories());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDto getCategoryByName(@PathVariable String name){

        return categoryService.getCategoryByName(name);
    }
}
