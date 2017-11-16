package com.betalpha.controller

import com.betalpha.BaseControllerSpec
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

/**
 * spec for {@link CsvController}
 * @author xiehai1
 * @date 2017/11/16 15:48
 * @Copyright ( c ) gome inc Gome Co.,LTD
 */
class CsvControllerSpec extends BaseControllerSpec {
    def index(){
        expect:
        super.doGet("/")
    }

    @Transactional
    @Rollback
    def upload(){
        expect:
        super.doPostFile("/upload", "csvFile", "2017-11-16.csv")
    }
}