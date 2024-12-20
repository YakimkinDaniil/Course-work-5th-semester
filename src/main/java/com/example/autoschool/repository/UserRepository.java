package com.example.autoschool.repository;

import com.example.autoschool.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с пользователями.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Найти пользователя по имени.
     *
     * @param username имя пользователя
     * @return пользователь
     */
    User findByUsername(String username);
}
