package com.example.autoschool.service;

import com.example.autoschool.model.ApplicationDTO;
import com.example.autoschool.model.Application;
import com.example.autoschool.repository.ApplicationRepository;
import com.example.autoschool.util.LocalDateToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервис для управления заявками.
 */
@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    /**
     * Создать новую заявку.
     *
     * @param applicationDTO данные заявки
     * @return созданная заявка
     */
    public ApplicationDTO createApplication(ApplicationDTO applicationDTO) {
        Application application = new Application();
        application.setStudentName(applicationDTO.getStudentName());
        application.setContactInfo(applicationDTO.getContactInfo());
        application.setApplicationDate(LocalDateToDateConverter.convertToDate(applicationDTO.getApplicationDate()));
        application = applicationRepository.save(application);
        applicationDTO.setStudentName(application.getStudentName());
        applicationDTO.setContactInfo(application.getContactInfo());
        applicationDTO.setApplicationDate(LocalDateToDateConverter.convertToLocalDate(application.getApplicationDate()));
        return applicationDTO;
    }

    /**
     * Получить все заявки.
     *
     * @return список заявок
     */
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    /**
     * Обновить заявку.
     *
     * @param id идентификатор заявки
     * @param applicationDetails данные заявки
     * @return обновленная заявка
     */
    public Application updateApplication(Long id, Application applicationDetails) {
        return applicationRepository.findById(id).map(application -> {
            application.setStudentName(applicationDetails.getStudentName());
            application.setContactInfo(applicationDetails.getContactInfo());
            application.setApplicationDate(applicationDetails.getApplicationDate());
            return applicationRepository.save(application);
        }).orElseThrow(() -> new RuntimeException("Заявка не найдена"));
    }

    /**
     * Удалить заявку.
     *
     * @param id идентификатор заявки
     */
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}
