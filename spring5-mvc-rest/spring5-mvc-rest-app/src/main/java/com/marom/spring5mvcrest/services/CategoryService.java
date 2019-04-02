package com.marom.spring5mvcrest.services;

import com.marom.spring5mvcrest.api.model.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryByName(String name);
}
