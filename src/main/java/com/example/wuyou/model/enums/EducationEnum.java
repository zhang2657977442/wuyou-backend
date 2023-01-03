package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EducationEnum {
    GZYX("高中以下", 0),
    GZ("高中", 1),
    ZZ("中专/技校", 2),
    DZ("大专", 3),
    BK("本科", 4),
    SS("硕士", 5),
    BS("博士", 6);

    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    EducationEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }


}
