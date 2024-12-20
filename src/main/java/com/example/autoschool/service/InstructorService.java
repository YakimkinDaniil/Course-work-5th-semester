package com.example.autoschool.service;

import com.example.autoschool.model.Instructor;
import com.example.autoschool.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервис для управления инструкторами.
 */
@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    /**
     * Получить всех инструкторов.
     *
     * @return список инструкторов
     */
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    /**
     * Создать нового инструктора.
     *
     * @param instructor данные инструктора
     * @return созданный инструктор
     */
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    /**
     * Обновить инструктора.
     *
     * @param id идентификатор инструктора
     * @param instructorDetails данные инструктора
     * @return обновленный инструктор
     */
    public Instructor updateInstructor(Long id, Instructor instructorDetails) {
        return instructorRepository.findById(id).map(instructor -> {
            instructor.setFirstName(instructorDetails.getFirstName());
            instructor.setLastName(instructorDetails.getLastName());
            instructor.setSpecialization(instructorDetails.getSpecialization());
            instructor.setContactInfo(instructorDetails.getContactInfo());
            instructor.setLessons(instructorDetails.getLessons());
            return instructorRepository.save(instructor);
        }).orElseThrow(() -> new RuntimeException("Инструктор не найден"));
    }

    /**
     * Удалить инструктора.
     *
     * @param id идентификатор инструктора
     */
    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }
}
