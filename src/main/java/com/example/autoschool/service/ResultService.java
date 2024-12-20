package com.example.autoschool.service;

import com.example.autoschool.model.ResultDTO;
import com.example.autoschool.model.Result;
import com.example.autoschool.model.Student;
import com.example.autoschool.model.StudentDTO;
import com.example.autoschool.repository.ResultRepository;
import com.example.autoschool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для управления результатами.
 */
@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Получить все результаты.
     *
     * @return список результатов
     */
    public List<ResultDTO> getAllResults() {
        List<Result> results = resultRepository.findAll();
        return results.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    /**
     * Преобразовать результат в DTO.
     *
     * @param result результат
     * @return DTO результата
     */
    private ResultDTO convertToDTO(Result result) {
        ResultDTO dto = new ResultDTO();
        dto.setId(result.getId());
        dto.setType(result.getType());
        dto.setDate(result.getDate());
        dto.setGrade(result.getGrade());
        if (result.getStudent() != null) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(result.getStudent().getId());
            studentDTO.setFirstName(result.getStudent().getFirstName());
            studentDTO.setLastName(result.getStudent().getLastName());
            dto.setStudent(studentDTO);
        }
        return dto;
    }

    /**
     * Создать новый результат.
     *
     * @param result данные результата
     * @return созданный результат
     */
    public Result createResult(Result result) {
        if (result.getType() == null || result.getType().isEmpty()) {
            throw new IllegalArgumentException("Тип не может быть нулевым или пустым");
        }
        if (result.getStudent() != null && result.getStudent().getId() != null) {
            Student student = studentRepository.findById(result.getStudent().getId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            result.setStudent(student);
        } else {
            throw new IllegalArgumentException("ID студента не может быть пустым");
        }
        return resultRepository.save(result);
    }

    /**
     * Обновить результат.
     *
     * @param id идентификатор результата
     * @param resultDetails данные результата
     * @return обновленный результат
     */
    public Result updateResult(Long id, Result resultDetails) {
        return resultRepository.findById(id).map(result -> {
            if (resultDetails.getType() == null || resultDetails.getType().isEmpty()) {
                throw new IllegalArgumentException("Тип не может быть нулевым или пустым");
            }
            result.setType(resultDetails.getType());
            result.setDate(resultDetails.getDate());
            result.setGrade(resultDetails.getGrade());
            Student student = studentRepository.findById(resultDetails.getStudent().getId())
                    .orElseThrow(() -> new RuntimeException("Студент не найден"));
            result.setStudent(student);
            return resultRepository.save(result);
        }).orElseThrow(() -> new RuntimeException("Результат не найден"));
    }

    /**
     * Удалить результат.
     *
     * @param id идентификатор результата
     */
    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }
}
