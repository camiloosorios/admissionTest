package com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository;

import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface MedicationJpaRepository extends JpaRepository<Medication, Long> {

    @Query("SELECT m FROM Medication m WHERE m.category.name = :categoryName AND m.expirationDate > :expiration")
    List<Medication> findByCategoryIdAndExpirationDate(String categoryName, LocalDate expiration);

}
