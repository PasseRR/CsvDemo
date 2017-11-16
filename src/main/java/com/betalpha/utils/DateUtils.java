package com.betalpha.utils;

import com.betalpha.exception.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * date utils
 * @author xiehai1
 * @date 2017/11/16 12:48
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public final class DateUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);
    private DateUtils() {

    }

    /**
     * parse yyyy-MM-dd string to {@link Date}
     * @param date date string
     * @return {@link Date}
     */
    public static Date parse(String date) {
        try {
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new CsvException("csv文件名格式不正确(必须为yyyy-MM-dd)!");
        }
    }
}
