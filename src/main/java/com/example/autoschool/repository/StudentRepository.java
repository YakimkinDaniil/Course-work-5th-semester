package com.example.autoschool.repository;

import com.example.autoschool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с обучающимся.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
