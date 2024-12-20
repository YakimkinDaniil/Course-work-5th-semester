package com.example.autoschool.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Утилита для преобразования LocalDate в Date и обратно.
 */
public class LocalDateToDateConverter {
    /**
     * Преобразовать LocalDate в Date.
     *
     * @param localDate дата в формате LocalDate
     * @return дата в формате Date
     */
    public static Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Преобразовать Date в LocalDate.
     *
     * @param date дата в формате Date
     * @return дата в формате LocalDate
     */
    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
