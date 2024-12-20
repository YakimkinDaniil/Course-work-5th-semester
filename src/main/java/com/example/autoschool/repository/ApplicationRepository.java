package com.example.autoschool.repository;

import com.example.autoschool.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с заявками.
 */
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
