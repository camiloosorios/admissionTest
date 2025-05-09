package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.application.dto.CreateMedicationDto;
import com.sprint3.admission_test.application.dto.MedicationDto;
import com.sprint3.admission_test.domain.model.Medication;

import java.time.LocalDate;
import java.util.List;

public interface IMedicationUseCase {
    Medication getMedicationById(Long id);
    CreateMedicationDto createMedication(CreateMedicationDto createMedicationDto);
    List<MedicationDto> getMedicationByCategoryAndExpiration(String categoryName, LocalDate expiration);
}
