package com.example.autoschool.repository;

import com.example.autoschool.model.Result;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Репозиторий для работы с результатами.
 */
@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    /**
     * Получить все результаты с графом сущностей.
     *
     * @return список результатов
     */
    @EntityGraph(attributePaths = "student")
    @Override
    List<Result> findAll();
}
