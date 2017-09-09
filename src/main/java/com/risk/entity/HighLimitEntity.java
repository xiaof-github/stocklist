package com.risk.entity;

import java.util.Date;

/**
 * Created by xiaof on 2017/9/3.
 */
public class HighLimitEntity {
    private Long index;
    private Date date;
    private String code;
    private String name;
    private Double preClose;
    private Double price;
    private Double high;
    private Double low;
    private Double volume;
    private Double amount;
    private String time;
    private Double high_limit;

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPreClose() {
        return preClose;
    }

    public void setPreClose(Double preClose) {
        this.preClose = preClose;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getHigh_limit() {
        return high_limit;
    }

    public void setHigh_limit(Double high_limit) {
        this.high_limit = high_limit;
    }
}
