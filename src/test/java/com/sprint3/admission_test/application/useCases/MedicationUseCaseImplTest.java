package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.dto.CreateMedicationDto;
import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MedicationUseCaseImplTest {

    @Mock
    private IMedicationRepository medicationRepository;

    @Mock
    private CategoryUseCaseImpl categoryUseCase;

    @InjectMocks
    private MedicationUseCaseImpl medicationUseCase;

    @Test
    public void createMedicationThrowErrorWhenCategoryNoExist() {
        CreateMedicationDto medicationDto = CreateMedicationDto.builder()
                .category_name("Example category")
                .build();
        when(categoryUseCase.getCategoryByName(any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> medicationUseCase.createMedication(medicationDto));
    }

}