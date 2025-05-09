package com.sprint3.admission_test.application.mapper;

import com.sprint3.admission_test.application.dto.CategoryDto;
import com.sprint3.admission_test.domain.model.Category;

public class CategoryMapper {

    public static CategoryDto fromCategoryToCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category fromCategoryDtoToCategory(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .build();
    }

}
