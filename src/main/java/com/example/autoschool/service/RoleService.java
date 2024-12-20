package com.example.autoschool.service;

import com.example.autoschool.model.Role;
import com.example.autoschool.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для управления ролями.
 */
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Сохранить роль.
     *
     * @param role данные роли
     * @return сохраненная роль
     */
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    /**
     * Найти роль по имени.
     *
     * @param name имя роли
     * @return роль
     */
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

}
