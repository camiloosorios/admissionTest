package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.dto.CreateMedicationDto;
import com.sprint3.admission_test.application.dto.MedicationDto;
import com.sprint3.admission_test.application.mapper.MedicationMapper;
import com.sprint3.admission_test.application.ports.in.ICategoryUseCase;
import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.sprint3.admission_test.application.mapper.MedicationMapper.fromMedicationToCreateMedicationDto;

@Service
public class MedicationUseCaseImpl implements IMedicationUseCase {

    @Autowired
    private IMedicationRepository medicationRepository;

    @Autowired
    private ICategoryUseCase categoryUseCase;

    @Override
    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Could not find medication with ID: " + id
        ));
    }

    @Override
    public CreateMedicationDto createMedication(CreateMedicationDto createMedicationDto) {

        Category category = categoryUseCase.getCategoryByName(createMedicationDto.getCategory_name())
                .orElseThrow(() -> new NotFoundException("Could not find medication category: " +
                        createMedicationDto.getCategory_name()));

        Medication medication = Medication.builder()
                .name(createMedicationDto.getName())
                .description(createMedicationDto.getDescription())
                .price(createMedicationDto.getPrice())
                .expirationDate(createMedicationDto.getExpiration_date())
                .category(category)
                .build();
        return fromMedicationToCreateMedicationDto(medicationRepository.save(medication));
    }

    @Override
    public List<MedicationDto> getMedicationByCategoryAndExpiration(String categoryName, LocalDate expiration) {
        return medicationRepository.findByCategoryAndExpiration(categoryName, expiration)
                .stream().map(MedicationMapper::fromMedicationToMedicationDto).toList();
    }
}
