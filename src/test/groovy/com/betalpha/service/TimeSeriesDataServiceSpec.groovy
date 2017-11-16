package com.betalpha.service

import com.betalpha.BaseSpec
import com.betalpha.dao.TimeSeriesDataMapper
import com.betalpha.model.TimeSeriesData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

/**
 * spec for {@link TimeSeriesDataService}
 * @author xiehai1
 * @date 2017/11/16 15:24
 * @Copyright ( c ) gome inc Gome Co.,LTD
 */
class TimeSeriesDataServiceSpec extends BaseSpec{
    @Autowired
    TimeSeriesDataService timeSeriesDataService
    @Autowired
    TimeSeriesDataMapper timeSeriesDataMapper

    def timeSeriesDataMapper(){
        expect:
        this.timeSeriesDataMapper != null
    }

    def timeSeriesDataService(){
        expect:
        this.timeSeriesDataService != null
    }

    @Transactional
    @Rollback
    def insertList(){
        given:
        def tradeDate = new Date()
        def list = [
            new TimeSeriesData(
                itemId: "1",
                stockCode: "1A",
                itemValue1: 1,
                itemValue2: 2,
                itemValue3: 3
            ),
            new TimeSeriesData(
                itemId: "2",
                stockCode: "2A",
                itemValue1: 2,
                itemValue2: 2,
                itemValue3: 2
            )
        ]

        expect:
        2 == this.timeSeriesDataService.insertList(tradeDate, list)

        when:
        def select = this.timeSeriesDataMapper.selectOne(
            new TimeSeriesData(stockCode: "1A")
        )
        then:
        select != null
        select.getItemValue1().intValue() == 1
        select.getItemValue2().intValue() == 2
        select.getItemValue3().intValue() == 3
    }
}
