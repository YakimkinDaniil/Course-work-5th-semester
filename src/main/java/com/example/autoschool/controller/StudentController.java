package com.example.autoschool.controller;

import com.example.autoschool.model.Student;
import com.example.autoschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Контроллер для управления обучающимися.
 */
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * Получить всех обучающихся.
     *
     * @return список обучающихся
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * Создать нового обучающегося.
     *
     * @param student данные обучающегося
     * @return созданный обучающийся
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    /**
     * Обновить обучающегося.
     *
     * @param id идентификатор обучающегося
     * @param studentDetails данные обучающегося
     * @return обновленный обучающейся
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }

    /**
     * Удалить обучающегося.
     *
     * @param id идентификатор обучающегося
     */
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
