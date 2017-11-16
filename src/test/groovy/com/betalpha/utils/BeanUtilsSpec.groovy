package com.betalpha.utils

import com.betalpha.exception.CsvException
import com.betalpha.model.TimeSeriesData
import spock.lang.Specification


/**
 * sepc for {@link BeanUtils}
 * @author xiehai1
 * @date 2017/11/16 15:00
 * @Copyright ( c ) gome inc Gome Co.,LTD
 */
class BeanUtilsSpec extends Specification {
    def setFieldValue() {
        when:
        def timeSeriesData = new TimeSeriesData()
        def field = timeSeriesData.getClass().getDeclaredField("itemId")
        field.setAccessible(true)
        def itemId = "3333"
        BeanUtils.setFieldValue(timeSeriesData, field, itemId)

        then:
        notThrown(Exception.class)
        timeSeriesData.getItemId() == itemId

        when:
        field = timeSeriesData.getClass().getDeclaredField("tradingDate")
        field.setAccessible(true)
        def tradingDate = "2017-11-11"
        BeanUtils.setFieldValue(timeSeriesData, field, tradingDate)
        then:
        thrown(CsvException.class)
    }
}