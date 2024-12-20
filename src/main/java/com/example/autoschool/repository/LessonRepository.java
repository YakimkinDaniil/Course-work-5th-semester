package com.example.autoschool.repository;

import com.example.autoschool.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с занятиями.
 */
@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
