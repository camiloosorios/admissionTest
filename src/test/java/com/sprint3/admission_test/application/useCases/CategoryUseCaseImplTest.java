package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.ports.in.ICategoryUseCase;
import com.sprint3.admission_test.application.ports.out.ICategoryRepository;
import com.sprint3.admission_test.domain.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CategoryUseCaseImplTest {

    @Mock
    private ICategoryRepository categoryRepository;

    @InjectMocks
    private CategoryUseCaseImpl categoryUseCase;


    @Test
    public void getCategoryNameReturnOptionalEmptyWhenCategoryDoesntExist() {
        when(categoryRepository.findByName(any())).thenReturn(Optional.empty());
        assertEquals(Optional.empty(), categoryUseCase.getCategoryByName(""));
    }

    @Test
    public void getCategoryNameReturnOptionalWithCategoryWhenCategoryExist() {
        Category category = Category.builder().name("Example").id(1L).build();
        when(categoryRepository.findByName(any())).thenReturn(Optional.of(category));
        assertEquals(1L, categoryUseCase.getCategoryByName("Example").get().getId());
    }



}