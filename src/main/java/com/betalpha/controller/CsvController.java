package com.betalpha.controller;

import com.betalpha.model.TimeSeriesData;
import com.betalpha.service.TimeSeriesDataService;
import com.betalpha.utils.CsvUtils;
import com.betalpha.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * csv files upload controller
 * @author xiehai1
 * @date 2017/11/16 11:41
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Controller
public class CsvController {
    @Autowired
    private TimeSeriesDataService timeSeriesDataService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvController.class);

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("csvFile") MultipartFile file, HttpServletRequest request) {
        try {
            String fileName = file.getOriginalFilename();
            request.setAttribute("isOk", true);
            request.setAttribute("message", "上传成功!");

            Date tradingDate = DateUtils.parse(CsvUtils.getFileNameWithoutSuffix(fileName));
            List<TimeSeriesData> list = CsvUtils.parseCvs(
                file,
                '\t',
                TimeSeriesData.class,
                "stockCode",
                "itemValue1",
                "itemValue2",
                "itemValue3"
            );

            list.forEach(item -> item.setTradingDate(tradingDate));

            this.timeSeriesDataService.insertList(tradingDate, list);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            request.setAttribute("isOk", false);
            request.setAttribute("message", e.getMessage());
        }

        return "/index";
    }
}
