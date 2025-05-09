package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryUseCase {
   Optional<Category> getCategoryByName(String categoryName);
}
