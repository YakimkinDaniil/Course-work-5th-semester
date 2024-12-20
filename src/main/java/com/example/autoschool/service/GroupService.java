package com.example.autoschool.service;

import com.example.autoschool.model.Group;
import com.example.autoschool.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервис для управления группами.
 */
@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    /**
     * Получить все группы.
     *
     * @return список групп
     */
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    /**
     * Создать новую группу.
     *
     * @param group данные группы
     * @return созданная группа
     */
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    /**
     * Обновить группу.
     *
     * @param id идентификатор группы
     * @param groupDetails данные группы
     * @return обновленная группа
     */
    public Group updateGroup(Long id, Group groupDetails) {
        return groupRepository.findById(id).map(group -> {
            group.setName(groupDetails.getName());
            group.setStartDate(groupDetails.getStartDate());
            group.setEndDate(groupDetails.getEndDate());
            group.setStudents(groupDetails.getStudents());
            return groupRepository.save(group);
        }).orElseThrow(() -> new RuntimeException("Группа не найдена"));
    }

    /**
     * Удалить группу.
     *
     * @param id идентификатор группы
     */
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
