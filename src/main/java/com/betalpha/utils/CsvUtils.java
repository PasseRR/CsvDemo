package com.betalpha.utils;

import com.betalpha.exception.CsvException;
import com.csvreader.CsvReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * csv utils
 * @author xiehai1
 * @date 2017/11/16 12:56
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public final class CsvUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvUtils.class);
    private CsvUtils() {

    }

    /**
     * parse csv file
     * @param file csv file
     * @param separator   csv separator
     * @param clazz       entity class
     * @param columns     csv header mapping entity properties order
     * @param <T>         entity class
     * @return {@link List&lt;T&gt;}
     */
    public static <T> List<T> parseCvs(MultipartFile file, char separator, Class<T> clazz, String... columns) throws IOException {
        List<T> list = new ArrayList<>();
        if (columns.length == 0) {
            return list;
        }
        final CsvReader csvReader = new CsvReader(file.getInputStream(), separator, Charset.forName("UTF-8"));
        try {
            csvReader.readHeaders();
            while (csvReader.readRecord()) {
                T item = clazz.newInstance();
                IntStream.range(0, columns.length)
                    .forEach(index -> {
                        boolean flag = false;
                        Field field = null;
                        try {
                            field = clazz.getDeclaredField(columns[index]);
                            flag = Modifier.isPublic(field.getModifiers());
                            if (!flag) {
                                field.setAccessible(true);
                            }
                            BeanUtils.setFieldValue(item, field, csvReader.get(index));
                        } catch (Exception e) {
                            throw new CsvException(e);
                        } finally {
                            if (null != field && !flag) {
                                field.setAccessible(false);
                            }
                        }
                    });
                list.add(item);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new CsvException("解析csv文件出错!");
        } finally {
            csvReader.close();
        }

        return list;
    }

    /**
     * get file name without suffix
     * @param fileName file name with suffix
     * @return file name
     */
    public static String getFileNameWithoutSuffix(String fileName) {
        if (!StringUtils.isEmpty(fileName)) {
            int lastDotIndex = fileName.lastIndexOf(".");
            if (lastDotIndex > -1) {
                return fileName.substring(0, lastDotIndex);
            }
        }

        return fileName;
    }
}
