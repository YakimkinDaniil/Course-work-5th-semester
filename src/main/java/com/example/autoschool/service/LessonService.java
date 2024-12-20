package com.example.autoschool.service;

import com.example.autoschool.model.Lesson;
import com.example.autoschool.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервис для управления занятиями.
 */
@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    /**
     * Получить все занятия.
     *
     * @return список занятий
     */
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    /**
     * Создать новое занятие.
     *
     * @param lesson данные занятия
     * @return созданное занятие
     */
    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    /**
     * Обновить занятие.
     *
     * @param id идентификатор занятия
     * @param lessonDetails данные занятия
     * @return обновленное занятие
     */
    public Lesson updateLesson(Long id, Lesson lessonDetails) {
        return lessonRepository.findById(id).map(lesson -> {
            lesson.setType(lessonDetails.getType());
            lesson.setDateTime(lessonDetails.getDateTime());
            lesson.setLocation(lessonDetails.getLocation());
            lesson.setInstructor(lessonDetails.getInstructor());
            lesson.setGroup(lessonDetails.getGroup());
            return lessonRepository.save(lesson);
        }).orElseThrow(() -> new RuntimeException("Занятие не найдено"));
    }

    /**
     * Удалить занятие.
     *
     * @param id идентификатор занятия
     */
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}