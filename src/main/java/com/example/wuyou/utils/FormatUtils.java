package com.example.wuyou.utils;

public class FormatUtils {
    public Double getTimeStampDouble(long timestamp){
        double value = (double) timestamp/1000;
        return value;
    }

    public Long getTimeStampLong(double timestamp){
        long value = new Double(timestamp * 1000).longValue();
        return value;
    }
}
