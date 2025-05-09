package com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository;

import com.sprint3.admission_test.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CategoryJpaRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.name = :categoryName")
    Optional<Category> findByName(String categoryName);
}
