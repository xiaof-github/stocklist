package com.risk.entity;

import java.io.Serializable;

/**
 * Created by xiaof on 2017/2/3.
 */
public class StockEntity implements Serializable{
    private long id;
    private String code;
    private float dayBeginPrice;
    private String result;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getDayBeginPrice() {
        return dayBeginPrice;
    }

    public void setDayBeginPrice(float dayBeginPrice) {
        this.dayBeginPrice = dayBeginPrice;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "StockEntity{" +
                "code='" + code + '\'' +
                ", dayBeginPrice=" + dayBeginPrice +
                ", result='" + result + '\'' +
                '}';
    }
}
