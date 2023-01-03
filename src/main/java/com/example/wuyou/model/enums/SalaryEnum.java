package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SalaryEnum {
    MY("面议", 0),
    K1("1-3K", 1),
    K3("3-5K", 2),
    K5("5-8K", 3),
    K8("8-12K", 4),
    K12("12-15K", 5),
    K15("15-20K", 6),
    K20("20K以上", 7);

    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    SalaryEnum(String text, int value) {
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
