package com.example.autoschool.controller;

import com.example.autoschool.model.ResultDTO;
import com.example.autoschool.model.*;
import com.example.autoschool.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Контроллер для администратора.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * Получить всех обучающихся.
     *
     * @return список обучающихся
     */
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return adminService.getAllStudents();
    }

    /**
     * Получить всех инструкторов.
     *
     * @return список инструкторов
     */
    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors() {
        return adminService.getAllInstructors();
    }

    /**
     * Получить все занятия.
     *
     * @return список занятий
     */
    @GetMapping("/lessons")
    public List<Lesson> getAllLessons() {
        return adminService.getAllLessons();
    }

    /**
     * Получить все результаты.
     *
     * @return список результатов
     */
    @GetMapping("/results")
    public List<ResultDTO> getAllResults() {
        return adminService.getAllResults();
    }

    /**
     * Получить все заявки.
     *
     * @return список заявок
     */
    @GetMapping("/applications")
    public List<Application> getAllApplications() {
        return adminService.getAllApplications();
    }
}
