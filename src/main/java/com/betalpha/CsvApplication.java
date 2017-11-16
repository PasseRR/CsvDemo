package com.betalpha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * application's entrance
 * @author xiehai1
 * @date 2017/11/16 11:20
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@SpringBootApplication
@MapperScan("com.betalpha.dao")
@RestController
public class CsvApplication {
    public static void main(String[] args) {
        SpringApplication.run(CsvApplication.class, args);
    }

    /**
     * simply check application is up or down
     * @return echo
     */
    @RequestMapping("/echo")
    @ResponseBody
    public String echo() {
        return "Hello, Csv!";
    }
}
