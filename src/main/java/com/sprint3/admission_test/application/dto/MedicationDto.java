package com.sprint3.admission_test.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicationDto {

    private Long id;

    @NotEmpty(message = "Medication name is required")
    @Length(min = 5, message = "Minimum 100 characters")
    @Length(max = 100, message = "Maximum 100 characters")
    private String name;

    @NotEmpty(message = "Medication description is required")
    @Length(min = 30, message = "Minimum 30 characters")
    @Length(max = 255, message = "Maximum 255 characters")
    private String description;

    @NotNull(message = "Medication price is required")
    @Min(value = 1, message = "Price must be greater than zero")
    private BigDecimal price;

    @NotNull(message = "Medication expiration date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiration_date;

    private CategoryDto category;
}
