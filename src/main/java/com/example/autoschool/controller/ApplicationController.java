package com.example.autoschool.controller;

import com.example.autoschool.model.ApplicationDTO;
import com.example.autoschool.model.Application;
import com.example.autoschool.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Контроллер для управления заявками.
 */
@RestController
@RequestMapping("/applications")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    /**
     * Получить все заявки.
     *
     * @return список заявок
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    /**
     * Создать новую заявку.
     *
     * @param applicationDTO данные заявки
     * @return созданная заявка
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApplicationDTO createApplication(@RequestBody ApplicationDTO applicationDTO) {
        return applicationService.createApplication(applicationDTO);
    }

    /**
     * Обновить заявку.
     *
     * @param id идентификатор заявки
     * @param applicationDetails данные заявки
     * @return обновленная заявка
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Application updateApplication(@PathVariable Long id, @RequestBody Application applicationDetails) {
        return applicationService.updateApplication(id, applicationDetails);
    }

    /**
     * Удалить заявку.
     *
     * @param id идентификатор заявки
     */
    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
    }
}
