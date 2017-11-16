package com.betalpha.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * time_series_data model
 * @author xiehai1
 * @date 2017/11/16 12:13
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class TimeSeriesData {
    @Id
    @Column(name = "item_id")
    private String itemId;
    @Id
    @Column(name = "trading_date")
    private Date tradingDate;
    @Id
    @Column(name = "stock_code")
    private String stockCode;
    @Column(name = "item_value1")
    private BigDecimal itemValue1;
    @Column(name = "item_value2")
    private BigDecimal itemValue2;
    @Column(name = "item_value3")
    private BigDecimal itemValue3;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public BigDecimal getItemValue1() {
        return itemValue1;
    }

    public void setItemValue1(BigDecimal itemValue1) {
        this.itemValue1 = itemValue1;
    }

    public BigDecimal getItemValue2() {
        return itemValue2;
    }

    public void setItemValue2(BigDecimal itemValue2) {
        this.itemValue2 = itemValue2;
    }

    public BigDecimal getItemValue3() {
        return itemValue3;
    }

    public void setItemValue3(BigDecimal itemValue3) {
        this.itemValue3 = itemValue3;
    }

    public Date getTradingDate() {
        return tradingDate;
    }

    public void setTradingDate(Date tradingDate) {
        this.tradingDate = tradingDate;
    }

    @Override
    public String toString() {
        return "TimeSeriesData{" +
            "itemId='" + itemId + '\'' +
            ", tradingDate=" + tradingDate +
            ", stockCode='" + stockCode + '\'' +
            ", itemValue1=" + itemValue1 +
            ", itemValue2=" + itemValue2 +
            ", itemValue3=" + itemValue3 +
            '}';
    }
}
