package com.sprint3.admission_test.application.mapper;

import com.sprint3.admission_test.application.dto.CreateMedicationDto;
import com.sprint3.admission_test.application.dto.MedicationDto;
import com.sprint3.admission_test.domain.model.Medication;

import static com.sprint3.admission_test.application.mapper.CategoryMapper.fromCategoryToCategoryDto;

public class MedicationMapper {

    public static CreateMedicationDto fromMedicationToCreateMedicationDto(Medication medication) {
        return CreateMedicationDto.builder()
                .id(medication.getId())
                .name(medication.getName())
                .description(medication.getDescription())
                .price(medication.getPrice())
                .category_name(medication.getCategory().getName())
                .expiration_date(medication.getExpirationDate())
                .build();
    }

    public static MedicationDto fromMedicationToMedicationDto(Medication medication) {
        return MedicationDto.builder()
                .id(medication.getId())
                .name(medication.getName())
                .description(medication.getDescription())
                .price(medication.getPrice())
                .category(fromCategoryToCategoryDto(medication.getCategory()))
                .expiration_date(medication.getExpirationDate())
                .build();
    }

}
