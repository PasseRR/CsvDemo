package com.betalpha.utils

import com.betalpha.exception.CsvException
import spock.lang.Specification


/**
 * spec for {@link DateUtils}
 * @author xiehai1
 * @date 2017/11/16 14:55
 * @Copyright ( c ) gome inc Gome Co.,LTD
 */
class DateUtilsSpec extends Specification {
    def parseCorrect(){
        given:
        def date = DateUtils.parse("2017-11-11")
        expect:
        date != null

        when:
        def calendar = Calendar.getInstance()
        calendar.setTime(date)
        then:
        calendar.get(Calendar.YEAR) == 2017
        calendar.get(Calendar.MONTH) == 10
        calendar.get(Calendar.DAY_OF_MONTH) == 11
    }

    def parseError(){
        when:
        def date = DateUtils.parse("20111--2--1")
        then:
        thrown(CsvException.class)
        date == null
    }
}