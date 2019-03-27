package com.marom.spring5mvcrest.services;

import com.marom.spring5mvcrest.api.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
