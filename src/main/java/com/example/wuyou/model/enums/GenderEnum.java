package com.example.wuyou.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum GenderEnum {
    MALE("男", 0),
    FEMALE("女", 1);

    @EnumValue
    private final int value;
    @JsonValue
    private final String text;


    GenderEnum(String text, int value) {
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
