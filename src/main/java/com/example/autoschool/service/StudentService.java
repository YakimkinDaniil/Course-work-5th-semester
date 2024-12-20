package com.example.autoschool.service;

import com.example.autoschool.model.Student;
import com.example.autoschool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервис для управления обучающимися.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    /**
     * Получить всех обучающихся.
     *
     * @return список обучающихся
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Создать нового обучающегося.
     *
     * @param student данные обучающегося
     * @return созданный обучающийся
     */
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Обновить обучающегося.
     *
     * @param id идентификатор обучающегося
     * @param studentDetails данные обучающегося
     * @return обновленный обучающийся
     */
    public Student updateStudent(Long id, Student studentDetails) {
        return studentRepository.findById(id).map(student -> {
            student.setFirstName(studentDetails.getFirstName());
            student.setLastName(studentDetails.getLastName());
            student.setBirthDate(studentDetails.getBirthDate());
            student.setContactInfo(studentDetails.getContactInfo());
            student.setStartDate(studentDetails.getStartDate());
            student.setEndDate(studentDetails.getEndDate());
            student.setGroup(studentDetails.getGroup());
            return studentRepository.save(student);
        }).orElseThrow(() -> new RuntimeException("Студент не найден"));
    }

    /**
     * Удалить обучающегося.
     *
     * @param id идентификатор обучающегося
     */
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
