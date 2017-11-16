package com.betalpha.service;

import com.betalpha.dao.TimeSeriesDataMapper;
import com.betalpha.model.TimeSeriesData;
import com.betalpha.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TimeSeriesData service
 * @author xiehai1
 * @date 2017/11/16 12:40
 * @Copyright(c) gome inc Gome Co.,LTD
 * @see com.betalpha.dao.TimeSeriesDataMapper
 */
@Service
public class TimeSeriesDataService {
    @Autowired
    private TimeSeriesDataMapper timeSeriesDataMapper;

    /**
     * insert {@link TimeSeriesData} list
     * @param tradingDate trade date
     * @param list        list data
     * @return insert rows
     */
    @Transactional(rollbackFor = Exception.class)
    public int insertList(Date tradingDate, List<TimeSeriesData> list) {
        final AtomicInteger insert = new AtomicInteger();
        list.forEach(item -> {
            item.setItemId(UuidUtils.getUuid());
            item.setTradingDate(tradingDate);
            insert.addAndGet(this.timeSeriesDataMapper.insertSelective(item));
        });

        return insert.get();
    }
}
