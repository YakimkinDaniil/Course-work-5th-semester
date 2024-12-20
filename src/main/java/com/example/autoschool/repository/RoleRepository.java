package com.example.autoschool.repository;

import com.example.autoschool.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с ролями.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Найти роль по имени.
     *
     * @param name имя роли
     * @return роль
     */
    Role findByName(String name);
}
