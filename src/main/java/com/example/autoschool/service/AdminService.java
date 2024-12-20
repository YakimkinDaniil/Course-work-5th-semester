package com.example.autoschool.service;

import com.example.autoschool.model.ResultDTO;
import com.example.autoschool.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервис для администратора.
 */
@Service
public class AdminService {
    @Autowired
    private StudentService studentService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private LessonService lessonService;
    @Autowired
    private ResultService resultService;
    @Autowired
    private ApplicationService applicationService;

    /**
     * Получить всех обучающихся.
     *
     * @return список обучающихся
     */
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * Получить всех инструкторов.
     *
     * @return список инструкторов
     */
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    /**
     * Получить все занятия.
     *
     * @return список занятий
     */
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    /**
     * Получить все результаты.
     *
     * @return список результатов
     */
    public List<ResultDTO> getAllResults() {
        return resultService.getAllResults();
    }

    /**
     * Получить все заявки.
     *
     * @return список заявок
     */
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }
}
