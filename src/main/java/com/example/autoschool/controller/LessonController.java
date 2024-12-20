package com.example.autoschool.controller;

import com.example.autoschool.model.Lesson;
import com.example.autoschool.service.LessonService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Контроллер для управления занятиями.
 */
@RestController
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    /**
     * Получить все занятия.
     *
     * @param request HTTP запрос
     * @return список занятий
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Lesson> getAllLessons(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        return lessonService.getAllLessons();
    }

    /**
     * Создать новое занятие.
     *
     * @param lesson данные занятия
     * @return созданное занятие
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonService.createLesson(lesson);
    }

    /**
     * Обновить занятие.
     *
     * @param id идентификатор занятия
     * @param lessonDetails данные занятия
     * @return обновленное занятие
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Lesson updateLesson(@PathVariable Long id, @RequestBody Lesson lessonDetails) {
        return lessonService.updateLesson(id, lessonDetails);
    }

    /**
     * Удалить занятие.
     *
     * @param id идентификатор занятия
     */
    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
    }
}