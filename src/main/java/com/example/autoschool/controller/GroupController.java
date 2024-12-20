package com.example.autoschool.controller;

import com.example.autoschool.model.Group;
import com.example.autoschool.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Контроллер для управления группами.
 */
@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    /**
     * Получить все группы.
     *
     * @return список групп
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    /**
     * Создать новую группу.
     *
     * @param group данные группы
     * @return созданная группа
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Group createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

    /**
     * Обновить группу.
     *
     * @param id идентификатор группы
     * @param groupDetails данные группы
     * @return обновленная группа
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Group updateGroup(@PathVariable Long id, @RequestBody Group groupDetails) {
        return groupService.updateGroup(id, groupDetails);
    }

    /**
     * Удалить группу.
     *
     * @param id идентификатор группы
     */
    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
    }
}
