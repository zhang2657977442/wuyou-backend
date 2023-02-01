package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CompanyNatureEnum {
    MY("私营/民营企业", 0),
    GY("国有企业", 1),
    HZ("合资企业", 2),
    OTHER("其他", 3);

    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    CompanyNatureEnum(String text, int value) {
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
