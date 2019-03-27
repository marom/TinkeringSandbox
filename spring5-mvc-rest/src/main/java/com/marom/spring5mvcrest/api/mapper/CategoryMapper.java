package com.marom.spring5mvcrest.api.mapper;

import com.marom.spring5mvcrest.api.model.CategoryDTO;
import com.marom.spring5mvcrest.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
