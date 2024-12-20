package com.example.autoschool.repository;

import com.example.autoschool.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Репозиторий для работы с инструкторами.
 */
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
