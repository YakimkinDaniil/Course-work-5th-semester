package com.example.autoschool.repository;

import com.example.autoschool.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с группами.
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
