package com.example.autoschool.controller;

import com.example.autoschool.model.Instructor;
import com.example.autoschool.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Контроллер для управления инструкторами.
 */
@RestController
@RequestMapping("/instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    /**
     * Получить всех инструкторов.
     *
     * @return список инструкторов
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    /**
     * Создать нового инструктора.
     *
     * @param instructor данные инструктора
     * @return созданный инструктор
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorService.createInstructor(instructor);
    }

    /**
     * Обновить инструктора.
     *
     * @param id идентификатор инструктора
     * @param instructorDetails данные инструктора
     * @return обновленный инструктор
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Instructor updateInstructor(@PathVariable Long id, @RequestBody Instructor instructorDetails) {
        return instructorService.updateInstructor(id, instructorDetails);
    }

    /**
     * Удалить инструктора.
     *
     * @param id идентификатор инструктора
     */
    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
    }
}
