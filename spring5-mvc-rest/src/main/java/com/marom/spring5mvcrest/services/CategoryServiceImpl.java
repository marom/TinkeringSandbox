package com.marom.spring5mvcrest.services;

import com.marom.spring5mvcrest.api.mapper.CategoryMapper;
import com.marom.spring5mvcrest.api.model.CategoryDTO;
import com.marom.spring5mvcrest.repositories.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {


    private CategoryMapper categoryMapper;
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository1) {
        super();
        this.categoryMapper = categoryMapper;
        categoryRepository = categoryRepository1;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
    }
}
