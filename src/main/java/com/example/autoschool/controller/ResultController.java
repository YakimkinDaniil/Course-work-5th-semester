package com.example.autoschool.controller;

import com.example.autoschool.model.ResultDTO;
import com.example.autoschool.model.Result;
import com.example.autoschool.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Контроллер для управления результатами.
 */
@RestController
@RequestMapping("/results")
public class ResultController {
    @Autowired
    private ResultService resultService;

    /**
     * Получить все результаты.
     *
     * @return список результатов
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ResultDTO> getAllResults() {
        List<ResultDTO> results = resultService.getAllResults();
        return results;
    }

    /**
     * Создать новый результат.
     *
     * @param result данные результата
     * @return созданный результат
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result createResult(@RequestBody Result result) {
        return resultService.createResult(result);
    }

    /**
     * Обновить результат.
     *
     * @param id идентификатор результата
     * @param resultDetails данные результата
     * @return обновленный результат
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result updateResult(@PathVariable Long id, @RequestBody Result resultDetails) {
        return resultService.updateResult(id, resultDetails);
    }

    /**
     * Удалить результат.
     *
     * @param id идентификатор результата
     */
    @DeleteMapping("/{id}")
    public void deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id);
    }
}
