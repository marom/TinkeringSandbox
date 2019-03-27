package com.marom.spring5mvcrest.controllers;

import com.marom.spring5mvcrest.api.model.CategoryDTO;
import com.marom.spring5mvcrest.api.model.CategoryListDTO;
import com.marom.spring5mvcrest.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/categories/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<CategoryListDTO> getAllCategories(){

        return new ResponseEntity<>(
                new CategoryListDTO(categoryService.getAllCategories()), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name){

        return new ResponseEntity<>(
                categoryService.getCategoryByName(name), HttpStatus.OK
        );
    }
}