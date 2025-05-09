package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.ports.in.ICategoryUseCase;
import com.sprint3.admission_test.application.ports.out.ICategoryRepository;
import com.sprint3.admission_test.domain.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryUseCaseImpl implements ICategoryUseCase {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Optional<Category> getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }
}
