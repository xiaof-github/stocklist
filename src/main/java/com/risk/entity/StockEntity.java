package com.risk.entity;

/**
 * Created by xiaof on 2017/2/3.
 */
public class StockEntity {
    private String code;
    private float dayBeginPrive;
    private String result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getDayBeginPrive() {
        return dayBeginPrive;
    }

    public void setDayBeginPrive(float dayBeginPrive) {
        this.dayBeginPrive = dayBeginPrive;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
