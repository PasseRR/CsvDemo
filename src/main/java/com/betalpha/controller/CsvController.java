package com.betalpha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * csv files upload controller
 * @author xiehai1
 * @date 2017/11/16 11:41
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Controller
public class CsvController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvController.class);
    @GetMapping("/")
    public String index(){
        return "/index";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("csvFile") MultipartFile file, HttpServletRequest request){
        LOGGER.debug(file.getOriginalFilename());
        request.setAttribute("isOk", true);
        request.setAttribute("message", "上传成功!");
        return "/index";
    }
}
